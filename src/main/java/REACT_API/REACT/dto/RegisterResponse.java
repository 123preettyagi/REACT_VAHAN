package REACT_API.REACT.dto;


import java.util.Set;

public class RegisterResponse {

    private String message;
    private String username;
    private String email;
    private Set<String> roles;

    // Default Constructor
    public RegisterResponse() {
    }

    // Parameterized Constructor
    public RegisterResponse(String message, String username, String email, Set<String> roles) {
        this.message = message;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }

    // Getters and Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}