package REACT_API.REACT.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class RegisterComplaintRequest {

	
	
	 @NotBlank(message = "Owner name is required")
	 @Size(min = 3, max = 12, message = "Owner name must be between 3 and 12 characters")
	    private String ownerName;

	    @NotBlank(message = "Vehicle number is required")
	    @Pattern(
	        regexp = "^[A-Z]{2}[0-9]{2}[A-Z]{2}[0-9]{4}$",
	        message = "Vehicle number must be in format: DL01AB1234"
	    )
	    private String vehicleNumber;

	    @NotBlank(message = "Vehicle type is required")
	    @Size(min = 3, max = 50, message = "Vehicle type must be between 3 and 50 characters")
	    private String vehicleType;

	    @NotBlank(message = "Category is required")
	    @Size(min = 3, max = 50, message = "Category must be between 3 and 50 characters")
	    private String category;

	    @NotBlank(message = "Contact number is required")
	    @Pattern(
	        regexp = "^[6-9]\\d{9}$",
	        message = "Contact number must be a valid 10-digit Indian mobile number"
	    )
	    private String contact;

	    @NotBlank(message = "Email is required")
	    @Email(message = "Invalid email format")
	    private String email;


	    @NotBlank(message = "Description is required")
	    @Size(min = 10, max = 50, message = "Description must be between 10 and 50 characters")
	    private String description;
	  
	    
	//DEFAULT CONSTRUCTOR
	public RegisterComplaintRequest() 
	{ }
	public RegisterComplaintRequest(String ownerName, String vehicleNumber,
            String vehicleType, String category,
            String contact, String email,
            String description) 
	
	{
	
		 this.ownerName = ownerName;
	        this.vehicleNumber = vehicleNumber;
	        this.vehicleType = vehicleType;
	        this.category = category;
	        this.contact = contact;
	        this.email = email;
	        this.description = description;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
    public String toString() {
        return "ComplaintRequest{" +
                "ownerName='" + ownerName + '\'' +
                ", vehicleNumber='" + vehicleNumber + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", category='" + category + '\'' +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}
