package REACT_API.REACT.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import REACT_API.REACT.dto.AuthenticationRequest;
import REACT_API.REACT.dto.AuthenticationResponse;
import REACT_API.REACT.dto.RegisterResponse;
import REACT_API.REACT.entity.User;
import REACT_API.REACT.repository.UserRepository;
import REACT_API.REACT.security.CustomUserDetailsService;
import REACT_API.REACT.security.JwtUtil;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private CustomUserDetailsService userDetailsService;
    
    @Autowired
    private JwtUtil jwtUtil;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {

        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body(
                    new RegisterResponse(
                            "Username already exists",
                            null,
                            null,
                            null
                    )
            );
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        if (user.getRoles() == null || user.getRoles().isEmpty()) {
            Set<String> roles = new HashSet<>();
            roles.add("USER");
            user.setRoles(roles);
        }

        user.setEnabled(true);

        User savedUser = userRepository.save(user);

        RegisterResponse response = new RegisterResponse(
                "User registered successfully",
                savedUser.getUsername(),
                savedUser.getEmail(),
                savedUser.getRoles()
        );

        return ResponseEntity.ok(response);
    }
    
    
    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }
        
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);
        
        User user = userRepository.findByUsername(authenticationRequest.getUsername()).get();
        
        return ResponseEntity.ok(new AuthenticationResponse(jwt, user.getUsername(), user.getRoles()));
    }
    


    
    
}