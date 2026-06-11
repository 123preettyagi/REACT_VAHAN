package REACT_API.REACT.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name="vahan_request")
public class ComplainStatus 
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="request_id",unique=true,nullable=false)
	private String requestId;
	
	@Column(name="applicant_name")
	private String applicationNumber;
	
	@Column(name="vehicle_number")
	private String vehicleNumber; 
	
	@Column(name="service_type")
	private String serviceType;
	
	@Column(name="amount")
	private Double amount;
	
	@Column(name="payment_status")
	private String paymentStatus;
	
	@Column(name="transaction_date")
	private LocalDateTime transactionDate;
	
	 @Column(name = "payment_method")
	 private String paymentMethod;
	
	@Column(name="refrence_number")
	private String refrenceNumber;
	
	public ComplainStatus()
	{ }
	
	
	public ComplainStatus(Long id,String requestId,String applicationNumber,
			String vehicleNumber,String serviceType,Double amount,String paymentStatus,LocalDateTime transactionDate,
	String paymentMethod	,String refrenceNumber)
	{
	this.id=id;
	this.requestId=requestId;
	this.applicationNumber=applicationNumber;
	this.vehicleNumber=vehicleNumber;
	this.serviceType=serviceType;
	this.amount=amount;
	this.paymentStatus=paymentStatus;
	this.transactionDate=transactionDate;
	this.paymentMethod=paymentMethod;
	this.refrenceNumber=refrenceNumber;
		
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getRequestId() {
		return requestId;
	}


	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}


	public String getApplicationNumber() {
		return applicationNumber;
	}


	public String getPaymentMethod() {
		return paymentMethod;
	}


	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}


	public void setApplicationNumber(String applicationNumber) {
		this.applicationNumber = applicationNumber;
	}


	public String getVehicleNumber() {
		return vehicleNumber;
	}


	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}


	public String getServiceType() {
		return serviceType;
	}


	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}


	


	public Double getAmount() {
		return amount;
	}


	public void setAmount(Double amount) {
		this.amount = amount;
	}


	public String getPaymentStatus() {
		return paymentStatus;
	}


	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}


	


	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}


	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}


	public String getRefrenceNumber() {
		return refrenceNumber;
	}


	public void setRefrenceNumber(String refrenceNumber) {
		this.refrenceNumber = refrenceNumber;
	}
	
	
	@Override
	public String toString()
	{
		return "ComplainStatus{" +
			       "id=" + id +
			       ", requestId='" + requestId + '\'' +
			       ", applicationNumber='" + applicationNumber + '\'' +
			       ", vehicleNumber='" + vehicleNumber + '\'' +
			       ", serviceType='" + serviceType + '\'' +
			       ", amount=" + amount +
			       ", paymentStatus='" + paymentStatus + '\'' +
			       ", transactionDate=" + transactionDate +
			       ", paymentMethod='" + paymentMethod + '\'' +
			       ", referenceNumber='" + refrenceNumber + '\'' +
			       '}';
	}
	

}
