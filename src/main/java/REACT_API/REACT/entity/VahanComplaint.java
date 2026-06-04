package REACT_API.REACT.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
@Entity
@Table(name = "vahan_complaints")
public class VahanComplaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500)
    private String feedbackDescription;
    
    public String getChassisNumber() {
		return chassisNumber;
	}

	public void setChassisNumber(String chassisNumber) {
		this.chassisNumber = chassisNumber;
	}

	@Column(nullable = false)  // Add this if chassis_number is required
    private String chassisNumber;  // Add this field

	@Column(name = "vehicle_registration_no")
    private String vehicleRegistrationNo;

    @Column(name = "application_number")
    private String applicationNo;

    private String rtoName;

    private String state;

    @Column(name = "transaction_purpose")
    private String transactionPurpose;

    @Column(name = "image_path", nullable = false)
    private String imagePath;

    private LocalDateTime createdAt;

    // Default Constructor
    public VahanComplaint() {
    }

    // Parameterized Constructor
    public VahanComplaint(Long id, String feedbackDescription, String chassisNumber,String vehicleRegistrationNo,
                          String applicationNo, String rtoName, String state,
                          String transactionPurpose, String imagePath,
                          LocalDateTime createdAt) {
        this.id = id;
        this.feedbackDescription = feedbackDescription;
        this.chassisNumber = chassisNumber;
        this.vehicleRegistrationNo = vehicleRegistrationNo;
        this.applicationNo = applicationNo;
        this.rtoName = rtoName;
        this.state = state;
        this.transactionPurpose = transactionPurpose;
        this.imagePath = imagePath;
        this.createdAt = createdAt;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFeedbackDescription() {
        return feedbackDescription;
    }

    public void setFeedbackDescription(String feedbackDescription) {
        this.feedbackDescription = feedbackDescription;
    }

    public String getVehicleRegistrationNo() {
        return vehicleRegistrationNo;
    }

    public void setVehicleRegistrationNo(String vehicleRegistrationNo) {
        this.vehicleRegistrationNo = vehicleRegistrationNo;
    }

    public String getApplicationNo() {
        return applicationNo;
    }

    public void setApplicationNo(String applicationNo) {
        this.applicationNo = applicationNo;
    }

    public String getRtoName() {
        return rtoName;
    }

    public void setRtoName(String rtoName) {
        this.rtoName = rtoName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTransactionPurpose() {
        return transactionPurpose;
    }

    public void setTransactionPurpose(String transactionPurpose) {
        this.transactionPurpose = transactionPurpose;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}