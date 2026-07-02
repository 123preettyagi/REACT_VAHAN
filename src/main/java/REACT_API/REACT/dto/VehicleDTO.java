package REACT_API.REACT.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class VehicleDTO {

    private Long id;

    @NotBlank(message = "Registration number is required")
    @Pattern(
        regexp = "^[A-Z]{2}\\d{2}[A-Z]{2}\\d{4}$",
        message = "Registration number must be in format: UP16AB1234"
    )
    private String registrationNumber;

    @NotBlank(message = "Chassis number is required")
    @Size(min = 17, max = 17, message = "Chassis number must be exactly 17 characters")
    private String chassisNumber;

    @NotBlank(message = "Owner name is required")
    @Size(max = 100, message = "Owner name must not exceed 100 characters")
    private String ownerName;

    @NotBlank(message = "Mobile number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be 10 digits")
    private String mobileNumber;

    @NotBlank(message = "Vehicle type is required")
    private String vehicleType;

    @NotBlank(message = "Fuel type is required")
    private String fuelType;

    @NotNull(message = "Registration date is required")
    @PastOrPresent(message = "Registration date cannot be in the future")
    private LocalDate registrationDate;

    @NotBlank(message = "RTO name is required")
    private String rtoName;

    // Default Constructor
    public VehicleDTO() {
    }

    // Parameterized Constructor
    public VehicleDTO(Long id, String registrationNumber, String chassisNumber,
                      String ownerName, String mobileNumber, String vehicleType,
                      String fuelType, LocalDate registrationDate, String rtoName) {
        this.id = id;
        this.registrationNumber = registrationNumber;
        this.chassisNumber = chassisNumber;
        this.ownerName = ownerName;
        this.mobileNumber = mobileNumber;
        this.vehicleType = vehicleType;
        this.fuelType = fuelType;
        this.registrationDate = registrationDate;
        this.rtoName = rtoName;
    }

    // Getters and Setters

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

    @Override
    public String toString() {
        return "VehicleDTO{" +
                "id=" + id +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", chassisNumber='" + chassisNumber + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", registrationDate=" + registrationDate +
                ", rtoName='" + rtoName + '\'' +
                '}';
    }
    
    
}