package REACT_API.REACT.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import REACT_API.REACT.entity.PasswordResetToken;
import REACT_API.REACT.entity.User;
import REACT_API.REACT.repository.PasswordResetTokenUserRepository;
import jakarta.transaction.Transactional;

@Service
public class PasswordResetService {

    @Autowired
    private PasswordResetTokenUserRepository tokenRepository;

    @Autowired
    private UserService userService;

    @Value("${app.frontend.url}")
    private String frontendUrl;

    @Transactional
    public String createPasswordResetToken(String email) 
    {
        Optional<User> userOptional = userService.findByEmail(email);
        if (userOptional.isEmpty()) {
            return null;
        }

        User user = userOptional.get();
        
        // Delete any existing tokens for this user
        tokenRepository.deleteByUser(user);
        tokenRepository.flush(); // force delete execution
        
        // Create new token
        String token = UUID.randomUUID().toString();
        LocalDateTime expiryDate = LocalDateTime.now().plusMinutes(15);
        
        PasswordResetToken resetToken = new PasswordResetToken(token, user, expiryDate);
        tokenRepository.save(resetToken);
        
        // Generate reset link
        return frontendUrl + "/reset-password?token=" + token;
    }

   
    
    public boolean validateResetToken(String token) {
        Optional<PasswordResetToken> tokenOptional = tokenRepository.findByToken(token);
        
        if (tokenOptional.isEmpty()) {
            return false;
        }
        
        PasswordResetToken resetToken = tokenOptional.get();
        
        if (resetToken.isUsed()) {
            return false;
        }
        
        if (resetToken.getExpiryDate().isBefore(LocalDateTime.now())) {
            return false;
        }
        
        return true;
    }

    @Transactional
    public boolean resetPassword(String token, String newPassword) {
        Optional<PasswordResetToken> tokenOptional = tokenRepository.findByToken(token);
        
        if (tokenOptional.isEmpty()) {
            return false;
        }
        
        PasswordResetToken resetToken = tokenOptional.get();
        
        if (!validateResetToken(token)) {
            return false;
        }
        
        User user = resetToken.getUser();
        user.setPassword(newPassword); // In production, encode this password!
        userService.saveUser(user);
        
        // Mark token as used
        resetToken.setUsed(true);
        tokenRepository.save(resetToken);
        
        return true;
    }
}