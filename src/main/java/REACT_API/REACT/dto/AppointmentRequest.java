package REACT_API.REACT.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class AppointmentRequest {

    @NotBlank(message = "Customer name is required")
    @Size(min = 2, max = 100, message = "Customer name must be between 2 and 100 characters")
    private String CustomerName;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String Email;

    @NotBlank(message = "Phone number is required")
    @Pattern(
        regexp = "^\\+?[0-9]{10,15}$",
        message = "Phone number must be 10-15 digits"
    )
    private String phoneNumber;
    
    @NotBlank(message = "Vehicle number is required")
    @Pattern(
        regexp = "^[A-Z]{2}[0-9]{2}[A-Z]{2}[0-9]{4}$",
        message = "Vehicle number must be in format DL01AB1234"
    )
    private String VehicleNumber;

    @NotBlank(message = "Vehicle type is required")
    private String vehicleType;

    @NotBlank(message = "Service type is required")
    private String ServiceType;

    @NotNull(message = "Preferred date is required")
    @FutureOrPresent(message = "Date must be today or in future")
    private LocalDate PreferredDate;

    @NotNull(message = "Preferred time is required")
    private LocalTime PreferredTime;

    @Size(max = 500, message = "Additional notes cannot exceed 500 characters")
    private String AdditionalNotes;

    // Default Constructor
    public AppointmentRequest() {
    }

    // Parameterized Constructor
    public AppointmentRequest(String CustomerName,
    		                   String Email,
    		                   String phoneNumber,
    		                   String VehicleNumber,
    		                   String vehicleType,
    		                   String ServiceType,
    		                   LocalDate PreferredDate,
    		                   LocalTime PreferredTime,
    		                   String AdditionalNotes
    		                   
    		
                             ) 
    {
    	this.CustomerName=CustomerName;
        this.Email=Email;
        this.phoneNumber=phoneNumber;
        this.VehicleNumber=VehicleNumber;
        this.vehicleType=vehicleType;
        this.ServiceType=ServiceType;
        this.PreferredDate=PreferredDate;
        this.PreferredTime=PreferredTime;
        this.AdditionalNotes=AdditionalNotes;
    	
       
    }

    // Getters and Setters

    
    
    
    

   

	public String getCustomerName() {
		return CustomerName;
	}

	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getVehicleNumber() {
		return VehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		VehicleNumber = vehicleNumber;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getServiceType() {
		return ServiceType;
	}

	public void setServiceType(String serviceType) {
		ServiceType = serviceType;
	}

	public LocalDate getPreferredDate() {
		return PreferredDate;
	}

	public void setPreferredDate(LocalDate preferredDate) {
		PreferredDate = preferredDate;
	}

	public LocalTime getPreferredTime() {
		return PreferredTime;
	}

	public void setPreferredTime(LocalTime preferredTime) {
		PreferredTime = preferredTime;
	}

	public String getAdditionalNotes() {
		return AdditionalNotes;
	}

	public void setAdditionalNotes(String additionalNotes) {
		AdditionalNotes = additionalNotes;
	}
	
	 @Override
	    public String toString() {
	        return "AppointmentRequest{" +
	                "CustomerName='" + CustomerName + '\'' +
	                ", Email='" + Email + '\'' +
	                 ", phoneNumber='" + phoneNumber + '\'' +
	                ", VehicleNumber='" + VehicleNumber + '\'' +
	                ", vehicleType='" + vehicleType + '\'' +
	                ", ServiceType='" + ServiceType + '\'' +
	                ", PreferredDate=" + PreferredDate +
	                ", PreferredTime=" + PreferredTime +
	                ", AdditionalNotes='" + AdditionalNotes + '\'' +
	                '}';
	    }
}