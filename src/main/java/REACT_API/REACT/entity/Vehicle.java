package REACT_API.REACT.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="vehicles")
public class Vehicle 
{
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;


@NotBlank(message = "Registration number is required")
@Pattern(
    regexp = "^[A-Z]{2}\\d{2}[A-Z]{2}\\d{4}$",
    message = "Registration number must be in format: UP16AB1234"
)
@Column(unique = true, nullable = false)
private String registrationNumber;

@NotBlank(message = "Chassis number is required")
@Size(min = 17, max = 17, message = "Chassis number must be exactly 17 characters")
@Column(unique = true, nullable = false)
private String chassisNumber;

@NotBlank(message = "Owner name is required")
@Size(max = 100, message = "Owner name must not exceed 100 characters")
@Column(nullable = false)
private String ownerName;

@NotBlank(message = "Mobile number is required")
@Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be 10 digits")
@Column(nullable = false)
private String mobileNumber;

@NotBlank(message = "Vehicle type is required")
private String vehicleType;

@NotBlank(message = "Fuel type is required")
private String fuelType;

@NotNull(message = "Registration date is required")
@PastOrPresent(message = "Registration date cannot be in the future")
@Column(nullable = false)
private LocalDate registrationDate;

@NotBlank(message = "RTO name is required")
@Column(nullable = false)
private String rtoName;

@Column(nullable = false)
private LocalDate createdAt;

private LocalDate updatedAt;
	
	
	

	public Vehicle() 
	{
		// TODO Auto-generated constructor stub
	}
	
	public Vehicle(Long id,String registrationNumber,String chassisNumber,String ownerName,String mobileNumber,String vehicleType,String fuelType,LocalDate registrationDate,String rtoName,LocalDate createdAt,LocalDate updatedAt)
	{
		
	this.id=id;
	this.registrationNumber=registrationNumber;
	this.chassisNumber=chassisNumber;
	this.ownerName=ownerName;
	this.mobileNumber=mobileNumber;
	this.vehicleType=vehicleType;
	this.fuelType=fuelType;
	this.registrationDate=registrationDate;
	this.rtoName=rtoName;
	this.createdAt=createdAt;
	this.updatedAt=updatedAt;	
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getChassisNumber() {
		return chassisNumber;
	}

	public void setChassisNumber(String chassisNumber) {
		this.chassisNumber = chassisNumber;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getRtoName() {
		return rtoName;
	}

	public void setRtoName(String rtoName) {
		this.rtoName = rtoName;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDate getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDate updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	@Override
	 public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", chassisNumber='" + chassisNumber + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", registrationDate=" + registrationDate +
                ", rtoName='" + rtoName + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
	

	
}
