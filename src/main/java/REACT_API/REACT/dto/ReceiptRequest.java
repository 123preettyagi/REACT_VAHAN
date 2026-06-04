package REACT_API.REACT.dto;

import jakarta.validation.constraints.NotBlank;

public class ReceiptRequest {

    @NotBlank(message = "Registration number is required")
    private String registrationNumber;

    @NotBlank(message = "Receipt number is required")
    private String receiptNumber;

    // Default Constructor
    public ReceiptRequest() {
    }

    // Parameterized Constructor
    public ReceiptRequest(String registrationNumber, String receiptNumber) {
        this.registrationNumber = registrationNumber;
        this.receiptNumber = receiptNumber;
    }

    // Getter and Setter
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }
}