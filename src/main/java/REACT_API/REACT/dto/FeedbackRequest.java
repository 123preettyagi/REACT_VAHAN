package REACT_API.REACT.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class FeedbackRequest {

	
	 @NotBlank(message = "Application Number is required")
	    @Pattern(
	        regexp = "^[A-Za-z0-9]+$",
	        message = "Application Number must contain only letters and numbers"
	    )
	    private String applicationNumber;

	    @NotBlank(message = "Chassis Number is required")
	    @Pattern(
	        regexp = "^[A-HJ-NPR-Z0-9]{17}$",
	        message = "Chassis Number must be 17 characters and contain only valid VIN characters"
	    )
	    private String chassisNumber;

	    
	    @NotBlank(message = "Email ID is required")
	    @Pattern(
	        regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$",
	        message = "Invalid Email ID format"
	    )
	    private String emailId;

	    
	    @NotBlank(message = "Vehicle Registration Number is required")
	    @Pattern(
	        regexp = "^[A-Z]{2}[0-9]{1,2}[A-Z]{1,3}[0-9]{4}$",
	        message = "Invalid Vehicle Registration Number format (e.g., UP16AB1234)"
	    )
	    private String vehicleRegistrationNo;
    

    public String getApplicationNumber() {
        return applicationNumber;
    }

    public void setApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public String getChassisNumber() {
        return chassisNumber;
    }

    public void setChassisNumber(String chassisNumber) {
        this.chassisNumber = chassisNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getVehicleRegistrationNo() {
        return vehicleRegistrationNo;
    }

    public void setVehicleRegistrationNo(String vehicleRegistrationNo) {
        this.vehicleRegistrationNo = vehicleRegistrationNo;
    }
}