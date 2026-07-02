package REACT_API.REACT.dto;

import jakarta.validation.constraints.NotBlank;

public class AppointmentSearchRequest {
    
    @NotBlank(message = "Customer name is required")
    private String customerName;
    
    private boolean exactMatch = false; // false = contains search, true = exact match
    
    // Default Constructor
    public AppointmentSearchRequest() {}
    
    // Parameterized Constructor
    public AppointmentSearchRequest(String customerName, boolean exactMatch) {
        this.customerName = customerName;
        this.exactMatch = exactMatch;
    }
    
    // Getters and Setters
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    
    public boolean isExactMatch() { return exactMatch; }
    public void setExactMatch(boolean exactMatch) { this.exactMatch = exactMatch; }
}