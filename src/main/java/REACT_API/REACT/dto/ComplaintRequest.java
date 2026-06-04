package REACT_API.REACT.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

public class ComplaintRequest {

   
    public String getChassisNumber() {
		return chassisNumber;
	}

	public void setChassisNumber(String chassisNumber) {
		this.chassisNumber = chassisNumber;
	}

	private String vehicleRegistrationNo;
    private String applicationNumber;
    
    private String chassisNumber; 
    
    @NotBlank(message = "Feedback description is required")
    private String feedbackDescription;
    
    @NotBlank(message = "State is required")
    private String state;
    
    @NotBlank(message = "RTO Name is required")
    private String rtoName;
    
    @NotBlank(message = "Transaction Purpose is required")
    private String transactionPurpose;

    @Column(name = "image_path", nullable = false)
    private String imagePath;
    

    public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getVehicleRegistrationNo() {
        return vehicleRegistrationNo;
    }

    public void setVehicleRegistrationNo(String vehicleRegistrationNo) {
        this.vehicleRegistrationNo = vehicleRegistrationNo;
    }

    public String getApplicationNumber() {
        return applicationNumber;
    }

    public void setApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    

    public String getFeedbackDescription() {
        return feedbackDescription;
    }

    public void setFeedbackDescription(String feedbackDescription) {
        this.feedbackDescription = feedbackDescription;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRtoName() {
        return rtoName;
    }

    public void setRtoName(String rtoName) {
        this.rtoName = rtoName;
    }

    public String getTransactionPurpose() {
        return transactionPurpose;
    }

    public void setTransactionPurpose(String transactionPurpose) {
        this.transactionPurpose = transactionPurpose;
    }
}