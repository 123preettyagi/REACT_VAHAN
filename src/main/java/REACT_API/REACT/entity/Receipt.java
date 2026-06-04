package REACT_API.REACT.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "receipts")
public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "receipt_number", nullable = false)
    private String receiptNumber;

    @Column(name = "registration_number", nullable = false)
    private String registrationNumber;

    private String status;

    @Column(name = "vehicle_number")
    private String vehicleNumber;

    // Default Constructor
    public Receipt() {
    }

    // Parameterized Constructor
    public Receipt(Long id,
                   String receiptNumber,
                   String registrationNumber,
                   String status,
                   String vehicleNumber) {
        this.id = id;
        this.receiptNumber = receiptNumber;
        this.registrationNumber = registrationNumber;
        this.status = status;
        this.vehicleNumber = vehicleNumber;
    }

    // Getter and Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "Receipt{" +
                "id=" + id +
                ", receiptNumber='" + receiptNumber + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", status='" + status + '\'' +
                ", vehicleNumber='" + vehicleNumber + '\'' +
                '}';
    }
}