package REACT_API.REACT.dto;

import java.time.LocalDateTime;

public class RegisterComplaintResponse {

	 // Only returning what client needs
    private Long id;
    private String ownerName;
    private String vehicleNumber;
    private String status;
    private LocalDateTime createdAt;
    private String message;

	
	public RegisterComplaintResponse() { }
	public RegisterComplaintResponse(Long id, String ownerName, String vehicleNumber,
            String status, LocalDateTime createdAt, String message) 
	{ 
		 this.id = id;
	        this.ownerName = ownerName;
	        this.vehicleNumber = vehicleNumber;
	        this.status = status;
	        this.createdAt = createdAt;
	        this.message = message;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	 // Static method for success response
	public static RegisterComplaintResponse sucess(RegisterComplaintResponse complaint)
	{
		RegisterComplaintResponse response=new RegisterComplaintResponse();
		 response.setId(complaint.getId());
	        response.setOwnerName(complaint.getOwnerName());
	        response.setVehicleNumber(complaint.getVehicleNumber());
	        response.setStatus(complaint.getStatus());
	        response.setCreatedAt(complaint.getCreatedAt());
	        response.setMessage("Complaint registered successfully");
	        return response;
	}
	
	// Static method for error response
	public static RegisterComplaintResponse error(String message)
	{
		RegisterComplaintResponse response=new RegisterComplaintResponse();
		 response.setMessage(message);
	        return response;
	}
	
	 @Override
	    public String toString() {
	        return "ComplaintResponse{" +
	                "id=" + id +
	                ", ownerName='" + ownerName + '\'' +
	                ", vehicleNumber='" + vehicleNumber + '\'' +
	                ", status='" + status + '\'' +
	                ", createdAt=" + createdAt +
	                ", message='" + message + '\'' +
	                '}';
	    }

}
