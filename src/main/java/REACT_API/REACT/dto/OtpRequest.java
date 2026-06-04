package REACT_API.REACT.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class OtpRequest {

	 @NotBlank(message = "Email is required")
	    @Email(message = "Please enter a valid email address")
    private String email;

    // Getter
    public String getEmail() {
        return email;
    }

    // Setter
    public void setEmail(String email) {
        this.email = email;
    }
}