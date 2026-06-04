package REACT_API.REACT.dto;

import java.time.LocalDateTime;

public class TransactionDTO {

    private Long id;
    private Double amount;
    private String applicationNo;
    private String bankRefNo;
    private String cin;
    private String grnNo;
    private LocalDateTime paymentConfDate;
    private LocalDateTime paymentDate;
    private String paymentGateway;
    private String paymentId;
    private String registrationNo;
    private String status;
    private String statusDescription;
    private String transactionId;
    private String vehicleNo;

    // Default Constructor
    public TransactionDTO() {
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getApplicationNo() {
        return applicationNo;
    }

    public void setApplicationNo(String applicationNo) {
        this.applicationNo = applicationNo;
    }

    public String getBankRefNo() {
        return bankRefNo;
    }

    public void setBankRefNo(String bankRefNo) {
        this.bankRefNo = bankRefNo;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getGrnNo() {
        return grnNo;
    }

    public void setGrnNo(String grnNo) {
        this.grnNo = grnNo;
    }

    public LocalDateTime getPaymentConfDate() {
        return paymentConfDate;
    }

    public void setPaymentConfDate(LocalDateTime paymentConfDate) {
        this.paymentConfDate = paymentConfDate;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentGateway() {
        return paymentGateway;
    }

    public void setPaymentGateway(String paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    // Optional: toString()

    @Override
    public String toString() {
        return "TransactionDTO{" +
                "id=" + id +
                ", amount=" + amount +
                ", applicationNo='" + applicationNo + '\'' +
                ", bankRefNo='" + bankRefNo + '\'' +
                ", cin='" + cin + '\'' +
                ", grnNo='" + grnNo + '\'' +
                ", paymentConfDate=" + paymentConfDate +
                ", paymentDate=" + paymentDate +
                ", paymentGateway='" + paymentGateway + '\'' +
                ", paymentId='" + paymentId + '\'' +
                ", registrationNo='" + registrationNo + '\'' +
                ", status='" + status + '\'' +
                ", statusDescription='" + statusDescription + '\'' +
                ", transactionId='" + transactionId + '\'' +
                ", vehicleNo='" + vehicleNo + '\'' +
                '}';
    }
}