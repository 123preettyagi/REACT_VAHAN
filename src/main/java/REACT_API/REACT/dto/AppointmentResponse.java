package REACT_API.REACT.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentResponse {
    private Long id;
    private String customerName;
    private String email;
    private String phoneNumber;
    private String vehicleNumber;
    private String vehicleType;
    private String serviceType;
    private LocalDate preferredDate;
    private LocalTime preferredTime;
    private String additionalNotes;

    // Default Constructor
    public AppointmentResponse() {}

    // Parameterized Constructor
    public AppointmentResponse(Long id, String customerName, String email, 
                               String phoneNumber, String vehicleNumber, 
                               String vehicleType, String serviceType, 
                               LocalDate preferredDate, LocalTime preferredTime, 
                               String additionalNotes) {
        this.id = id;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.serviceType = serviceType;
        this.preferredDate = preferredDate;
        this.preferredTime = preferredTime;
        this.additionalNotes = additionalNotes;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getVehicleNumber() { return vehicleNumber; }
    public void setVehicleNumber(String vehicleNumber) { this.vehicleNumber = vehicleNumber; }

    public String getVehicleType() { return vehicleType; }
    public void setVehicleType(String vehicleType) { this.vehicleType = vehicleType; }

    public String getServiceType() { return serviceType; }
    public void setServiceType(String serviceType) { this.serviceType = serviceType; }

    public LocalDate getPreferredDate() { return preferredDate; }
    public void setPreferredDate(LocalDate preferredDate) { this.preferredDate = preferredDate; }

    public LocalTime getPreferredTime() { return preferredTime; }
    public void setPreferredTime(LocalTime preferredTime) { this.preferredTime = preferredTime; }

    public String getAdditionalNotes() { return additionalNotes; }
    public void setAdditionalNotes(String additionalNotes) { this.additionalNotes = additionalNotes; }
}
