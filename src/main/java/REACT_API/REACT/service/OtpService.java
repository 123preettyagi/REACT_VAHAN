package REACT_API.REACT.service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class OtpService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${otp.expiry.minutes:5}")
    private int otpExpiryMinutes;

    @Value("${otp.length:6}")
    private int otpLength;

    @Value("${spring.mail.username}")
    private String fromEmail;

    //  HashMap to store OTP: key = email, value = OtpData
    private final Map<String, OtpData> otpStore = new HashMap<>();

    // ─── Inner class to hold OTP + expiry ───────────────────────
    private static class OtpData {
        String otp;
        LocalDateTime expiryTime;
        int attemptCount;

        OtpData(String otp, LocalDateTime expiryTime) {
            this.otp = otp;
            this.expiryTime = expiryTime;
            this.attemptCount = 0;
        }
    }

    // ─── Generate OTP ────────────────────────────────────────────
    private String generateOtp() {
        SecureRandom random = new SecureRandom();
        StringBuilder otp = new StringBuilder();
        for (int i = 0; i < otpLength; i++) {
            otp.append(random.nextInt(10));
        }
        return otp.toString();
    }

    // ─── Send OTP to Email ───────────────────────────────────────
    public String sendOtp(String email) {
        // Validate email format
        if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("Invalid email address");
        }

        String otp = generateOtp();
        LocalDateTime expiry = LocalDateTime.now().plusMinutes(otpExpiryMinutes);

        // Store in HashMap
        otpStore.put(email.toLowerCase(), new OtpData(otp, expiry));

        // Send email
        sendEmail(email, otp);

        System.out.println(" OTP [" + otp + "] sent to: " + email);
        return otp; // returned for testing; remove in production
    }

    // ─── Verify OTP ──────────────────────────────────────────────
    public String verifyOtp(String email, String otp) {
        String key = email.toLowerCase();
        OtpData otpData = otpStore.get(key);

        if (otpData == null) {
            return "OTP_NOT_FOUND";
        }

        if (LocalDateTime.now().isAfter(otpData.expiryTime)) {
            otpStore.remove(key); // clean up expired OTP
            return "OTP_EXPIRED";
        }

        if (otpData.attemptCount >= 3) {
            otpStore.remove(key); // too many failed attempts
            return "TOO_MANY_ATTEMPTS";
        }

        if (!otpData.otp.equals(otp)) {
            otpData.attemptCount++;
            return "OTP_INVALID";
        }

        //  OTP matched — remove from store (one-time use)
        otpStore.remove(key);
        return "OTP_VERIFIED";
    }

    
    // ─── Email Sender ────────────────────────────────────────────
    private void sendEmail(String toEmail, String otp) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(toEmail);
        message.setSubject("Your OTP Verification Code");
        message.setText(
            "Dear User,\n\n" +
            "Your One-Time Password (OTP) for verification is:\n\n" +
            "🔐  " + otp + "\n\n" +
            "This OTP is valid for " + otpExpiryMinutes + " minutes.\n" +
            "Do NOT share this OTP with anyone.\n\n" +
            "If you did not request this, please ignore this email.\n\n" +
            "Regards,\nOTP Service Team"
        );
        mailSender.send(message);
    }
}