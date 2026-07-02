package REACT_API.REACT.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;

@Entity
@Table(name = "complaints", indexes = {
        @Index(name = "idx_vehicle_number", columnList = "vehicleNumber"),
        @Index(name = "idx_email", columnList = "email")
})
public class RegisterComplaint 
{
	
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false)
	    private String ownerName;

	    @Column(nullable = false, unique = true)
	    private String vehicleNumber;

	    @Column(nullable = false)
	    private String vehicleType;

	    @Column(nullable = false)
	    private String category;

	    private String contact;

	    @Column(nullable = false)
	    private String email;

	    @Column(length = 1000)
	    private String description;

	    @CreationTimestamp
	    @Column(updatable = false)
	    private LocalDateTime createdAt;

	    private String status = "PENDING";
	
	
	

	public RegisterComplaint()
	{ }
	
	public RegisterComplaint(Long id, String ownerName, String vehicleNumber,
            String vehicleType, String category, String contact,
            String email, String description,
            LocalDateTime createdAt, String status)
	{
		 this.id = id;
	        this.ownerName = ownerName;
	        this.vehicleNumber = vehicleNumber;
	        this.vehicleType = vehicleType;
	        this.category = category;
	        this.contact = contact;
	        this.email = email;
	        this.description = description;
	        this.createdAt = createdAt;
	        this.status = status;
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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	 // toString()

    @Override
    public String toString() {
        return "Complaint{" +
                "id=" + id +
                ", ownerName='" + ownerName + '\'' +
                ", vehicleNumber='" + vehicleNumber + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", category='" + category + '\'' +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", status='" + status + '\'' +
                '}';
    }
	
	
	

}
