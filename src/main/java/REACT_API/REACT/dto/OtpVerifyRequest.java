package REACT_API.REACT.dto;

public class OtpVerifyRequest {

    private String email;
    private String otp;

    // Default Constructor
    public OtpVerifyRequest() {
    }

    // Parameterized Constructor
    public OtpVerifyRequest(String email, String otp) {
        this.email = email;
        this.otp = otp;
    }

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Setter for email
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter for otp
    public String getOtp() {
        return otp;
    }

    // Setter for otp
    public void setOtp(String otp) {
        this.otp = otp;
    }

    @Override
    public String toString() {
        return "OtpVerifyRequest{" +
                "email='" + email + '\'' +
                ", otp='" + otp + '\'' +
                '}';
    }
}