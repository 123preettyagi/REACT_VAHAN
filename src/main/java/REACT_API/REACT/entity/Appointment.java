package REACT_API.REACT.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Customer name is required")
    @Size(min = 2, max = 100, message = "Customer name must be between 2 and 100 characters")
    @Column(name = "Customer_Name", nullable = false)
    private String CustomerName;



    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    @Column(nullable = false)
    private String Email;

    @NotBlank(message = "Phone number is required")
    @Pattern(
        regexp = "^\\+?[0-9]{10,15}$",
        message = "Phone number must be 10-15 digits"
    )
    @Column(name = "Phone_Number", nullable = false)
    private String PhoneNumber;
    
    @NotBlank(message = "Vehicle number is required")
    @Pattern(
        regexp = "^[A-Z]{2}[0-9]{2}[A-Z]{2}[0-9]{4}$",
        message = "Vehicle number must be in format DL01AB1234"
    )
    @Column(name = "Vehicle_Number", nullable = false)
    private String VehicleNumber;

    @NotBlank(message = "Vehicle type is required")
    @Column(name = "Vehicle_Type", nullable = false)
    private String VehicleType;

    @NotBlank(message = "Service type is required")
    @Column(name = "Service_Type", nullable = false)
    private String ServiceType;

    @NotNull(message = "Preferred date is required")
    @FutureOrPresent(message = "Date must be today or in future")
    @Column(name = "Preferred_Date", nullable = false)
    private LocalDate PreferredDate;

    @NotNull(message = "Preferred time is required")
    @Column(name = " Preferred_Time", nullable = false)
    private LocalTime PreferredTime;

    @Column(name = "Additional_Notes", length = 500)
    private String  AdditionalNotes;

  

    // Default Constructor
    public Appointment() {
    }

    // Parameterized Constructor
    public Appointment(
            Long id,
            String CustomerName,
            String Email,
            String PhoneNumber,
            String VehicleNumber,
            String VehicleType,
            String ServiceType,
            LocalDate PreferredDate,
            LocalTime PreferredTime,
            String AdditionalNotes
            ) 
    {

        this.id = id;
        this.CustomerName = CustomerName;
       this.Email=Email;
       this.PhoneNumber=PhoneNumber;
       this.VehicleNumber=VehicleNumber;
       this.VehicleType=VehicleType;
       this.ServiceType=ServiceType;
       this.PreferredDate=PreferredDate;
       this.PreferredTime=PreferredTime;
       this.AdditionalNotes=AdditionalNotes;
       
       
    }

    // Getters and Setters

    
    

    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public String getVehicleNumber() {
		return VehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		VehicleNumber = vehicleNumber;
	}

	public String getVehicleType() {
		return VehicleType;
	}

	public void setVehicleType(String vehicleType) {
		VehicleType = vehicleType;
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
    public String toString() 
    {
        return "Appointment{" +
                "id=" + id +
                ", CustomerName='" + CustomerName + '\'' +
                ", Email='" + Email + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", VehicleNumber='" + VehicleNumber + '\'' +
                ", VehicleType='" + VehicleType + '\'' +
                ", ServiceType='" + ServiceType + '\'' +
                ", PreferredDate=" + PreferredDate +
                ", PreferredTime=" + PreferredTime +
                ", AdditionalNotes='" + AdditionalNotes + '\'' +
                '}';
    }
    
}