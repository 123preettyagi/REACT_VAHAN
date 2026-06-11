package REACT_API.REACT.dto;

import java.time.LocalDateTime;

public class ComplainStatusResponse {

    private String requestId;
    private String applicantName;
    private String vehicleNumber;
    private String serviceType;
    private Double amount;
    private String paymentStatus;
    private LocalDateTime transactionDate;
    private String paymentMethod;
    private String referenceNumber;
    private String message;
    private boolean success;

    // Default Constructor
    public ComplainStatusResponse() {
    }

    // Private Constructor for Builder
    private ComplainStatusResponse(Builder builder) {
        this.requestId = builder.requestId;
        this.applicantName = builder.applicantName;
        this.vehicleNumber = builder.vehicleNumber;
        this.serviceType = builder.serviceType;
        this.amount = builder.amount;
        this.paymentStatus = builder.paymentStatus;
        this.transactionDate = builder.transactionDate;
        this.paymentMethod = builder.paymentMethod;
        this.referenceNumber = builder.referenceNumber;
        this.message = builder.message;
        this.success = builder.success;
    }

    // Getters and Setters

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    // Builder Class
    public static class Builder {
        private String requestId;
        private String applicantName;
        private String vehicleNumber;
        private String serviceType;
        private Double amount;
        private String paymentStatus;
        private LocalDateTime transactionDate;
        private String paymentMethod;
        private String referenceNumber;
        private String message;
        private boolean success;

        public Builder requestId(String requestId) {
            this.requestId = requestId;
            return this;
        }

        public Builder applicantName(String applicantName) {
            this.applicantName = applicantName;
            return this;
        }

        public Builder vehicleNumber(String vehicleNumber) {
            this.vehicleNumber = vehicleNumber;
            return this;
        }

        public Builder serviceType(String serviceType) {
            this.serviceType = serviceType;
            return this;
        }

        public Builder amount(Double amount) {
            this.amount = amount;
            return this;
        }

        public Builder paymentStatus(String paymentStatus) {
            this.paymentStatus = paymentStatus;
            return this;
        }

        public Builder transactionDate(LocalDateTime transactionDate) {
            this.transactionDate = transactionDate;
            return this;
        }

        public Builder paymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Builder referenceNumber(String referenceNumber) {
            this.referenceNumber = referenceNumber;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder success(boolean success) {
            this.success = success;
            return this;
        }

        public ComplainStatusResponse build() {
            return new ComplainStatusResponse(this);
        }
    }

    
    public static Builder builder() {
        return new Builder();
    }
}