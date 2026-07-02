package REACT_API.REACT.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "feedbackdata")
public class FeedbackData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String applicationNumber;

    @Column(unique = true)
    private String chassisNumber;

    @Column(unique = true)
    private String vehicleRegistrationNo;

    
    private String emailId;

    private String rtoName;

    private String state;
    

    // Default Constructor
    public FeedbackData() {
    }

    // Parameterized Constructor
    public FeedbackData(Long id, String applicationNumber, String chassisNumber,
                        String emailId, String vehicleRegistrationNo,String rtoName,String state ) {
        this.id = id;
        this.applicationNumber = applicationNumber;
        this.chassisNumber = chassisNumber;
        this.emailId = emailId;
        this.vehicleRegistrationNo = vehicleRegistrationNo;
        this.rtoName=rtoName;
        this.state=state;
    }

    // Getters and Setters

    
    public Long getId() {
        return id;
    }

    public String getRtoName() {
		return rtoName;
	}

	public void setRtoName(String rtoName) {
		this.rtoName = rtoName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setId(Long id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "FeedbackData{" +
                "id=" + id +
                ", applicationNumber='" + applicationNumber + '\'' +
                ", chassisNumber='" + chassisNumber + '\'' +
                ", emailId='" + emailId + '\'' +
                ", vehicleRegistrationNo='" + vehicleRegistrationNo + '\'' +
                ", state='" + state + '\'' +
                ", rtoName='" + rtoName + '\'' +
                '}';
    }
}