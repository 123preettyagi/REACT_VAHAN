package REACT_API.REACT.dto;

import java.util.Set;

public class AuthenticationResponse {

    private String jwt;
    private String username;
    private Set<String> roles;

    // Default Constructor
    public AuthenticationResponse() {
    }

    // Parameterized Constructor
    public AuthenticationResponse(String jwt, String username, Set<String> roles) {
        this.jwt = jwt;
        this.username = username;
        this.roles = roles;
    }

    // Getter for jwt
    public String getJwt() {
        return jwt;
    }

    // Setter for jwt
    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    // Getter for username
    public String getUsername() {
        return username;
    }

    // Setter for username
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter for roles
    public Set<String> getRoles() {
        return roles;
    }

    // Setter for roles
    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    // toString Method
    @Override
    public String toString() {
        return "AuthenticationResponse{" +
                "jwt='" + jwt + '\'' +
                ", username='" + username + '\'' +
                ", roles=" + roles +
                '}';
    }
}