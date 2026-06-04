package REACT_API.REACT.dto;

public class ReceiptResponse {

    private String receiptNumber;
    private String registrationNumber;
    private String status;
    private String vehicleNumber;

    // Default Constructor
    public ReceiptResponse() {
    }

    // Parameterized Constructor
    public ReceiptResponse(String receiptNumber,
                           String registrationNumber,
                           String status,
                           String vehicleNumber) {
        this.receiptNumber = receiptNumber;
        this.registrationNumber = registrationNumber;
        this.status = status;
        this.vehicleNumber = vehicleNumber;
    }

    // Getter and Setter
    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
}