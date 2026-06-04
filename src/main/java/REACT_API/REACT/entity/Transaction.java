package REACT_API.REACT.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "application_no")
    private String applicationNo;

    @Column(name = "bank_ref_no")
    private String bankRefNo;

    @Column(name = "cin")
    private String cin;

    @Column(name = "grn_no")
    private String grnNo;
    
    
    @Column(name = "payment_conf_date")
    private LocalDateTime paymentConfDate;

    @Column(name = "payment_date")
    private LocalDateTime paymentDate;

    @Column(name = "payment_gateway")
    private String paymentGateway;

    @Column(name = "payment_id")
    private String paymentId;

    @Column(name = "registration_no")
    private String registrationNo;

    @Column(name = "status")
    private String status;

    @Column(name = "status_description")
    private String statusDescription;

    @Column(name = "transaction_id")
    private String transactionId;

    @Column(name = "vehicle_no")
    private String vehicleNo;

    // Default Constructor
    public Transaction() {
    }

    // Parameterized Constructor
    public Transaction(Long id, Double amount, String applicationNo, String bankRefNo,
                       String cin, String grnNo, LocalDateTime paymentConfDate,
                       LocalDateTime paymentDate, String paymentGateway, String paymentId,
                       String registrationNo, String status, String statusDescription,
                       String transactionId, String vehicleNo) {

        this.id = id;
        this.amount = amount;
        this.applicationNo = applicationNo;
        this.bankRefNo = bankRefNo;
        this.cin = cin;
        this.grnNo = grnNo;
        this.paymentConfDate = paymentConfDate;
        this.paymentDate = paymentDate;
        this.paymentGateway = paymentGateway;
        this.paymentId = paymentId;
        this.registrationNo = registrationNo;
        this.status = status;
        this.statusDescription = statusDescription;
        this.transactionId = transactionId;
        this.vehicleNo = vehicleNo;
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

    // toString Method
    @Override
    public String toString() {
        return "Transaction{" +
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