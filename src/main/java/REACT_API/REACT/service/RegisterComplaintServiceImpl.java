package REACT_API.REACT.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import REACT_API.REACT.dto.RegisterComplaintRequest;
import REACT_API.REACT.dto.RegisterComplaintResponse;
import REACT_API.REACT.entity.RegisterComplaint;
import REACT_API.REACT.repository.RegisterComplaintRepository;
import jakarta.transaction.Transactional;

@Service
public class RegisterComplaintServiceImpl  implements RegisterComplaintService
{

	 private static final Logger log =
	            LoggerFactory.getLogger(RegisterComplaintServiceImpl.class);
	
	 private final RegisterComplaintRepository complaintRepository;
	 
	public RegisterComplaintServiceImpl(RegisterComplaintRepository complaintRepository) 
	{
		 this.complaintRepository = complaintRepository;
	}

	
	  @Override
	  @Transactional
	  public RegisterComplaintResponse registerComplaint(RegisterComplaintRequest request) {

	        log.info("Registering complaint for vehicle: {}", request.getVehicleNumber());

	        // Check if complaint already exists
	        if (complaintRepository.existsByVehicleNumber(request.getVehicleNumber())) {
	            return RegisterComplaintResponse.error(
	                    "Complaint already exists for this vehicle");
	        }

	        // Create new complaint entity
	        RegisterComplaint complaint = new RegisterComplaint();
	        complaint.setOwnerName(request.getOwnerName());
	        complaint.setVehicleNumber(request.getVehicleNumber());
	        complaint.setVehicleType(request.getVehicleType());
	        complaint.setCategory(request.getCategory());
	        complaint.setContact(request.getContact());
	        complaint.setEmail(request.getEmail());
	        complaint.setDescription(request.getDescription());
	        complaint.setStatus("PENDING");

	        // Save to database
	        RegisterComplaint savedComplaint = complaintRepository.save(complaint);

	        log.info("Complaint registered successfully with ID: {}",
	                savedComplaint.getId());

	        RegisterComplaintResponse response = new RegisterComplaintResponse();
	        response.setId(savedComplaint.getId());
	        response.setOwnerName(savedComplaint.getOwnerName());
	        response.setVehicleNumber(savedComplaint.getVehicleNumber());
	        response.setStatus(savedComplaint.getStatus());
	        response.setCreatedAt(savedComplaint.getCreatedAt());

	        return RegisterComplaintResponse.sucess(response);
	    }
	    
	/*  @Override
	    @Cacheable(value = "complaints", key = "#vehicleNumber")
	    public RegisterComplaintResponse getComplaintByVehicleNumber(String vehicleNumber) {
	        log.info("Fetching complaint for vehicle: {}", vehicleNumber);
	        
	        return complaintRepository.findByVehicleNumber(vehicleNumber)
	                .map(complaint -> {

	                    RegisterComplaintResponse response = new RegisterComplaintResponse();
	                    response.setId(complaint.getId());
	                    response.setOwnerName(complaint.getOwnerName());
	                    response.setVehicleNumber(complaint.getVehicleNumber());
	                    response.setStatus(complaint.getStatus());
	                    response.setCreatedAt(complaint.getCreatedAt());

	                    return response;
	                })
	                .orElse(RegisterComplaintResponse.error(
	                        "Complaint not found for vehicle: " + vehicleNumber));
	    } */

	    @Override
	    @Cacheable(value = "complaints", key = "#vehicleNumber")
	    public RegisterComplaintResponse getComplaintByVehicleNumber(String vehicleNumber) {

	        log.info("Fetching complaint for vehicle: {}", vehicleNumber);

	        return complaintRepository.findByVehicleNumber(vehicleNumber)
	                .map(this::mapToResponse)
	                .orElse(RegisterComplaintResponse.error(
	                        "Complaint not found for vehicle: " + vehicleNumber));
	    }

	    private RegisterComplaintResponse mapToResponse(RegisterComplaint complaint) {

	        RegisterComplaintResponse response = new RegisterComplaintResponse();
	        response.setId(complaint.getId());
	        response.setOwnerName(complaint.getOwnerName());
	        response.setVehicleNumber(complaint.getVehicleNumber());
	        response.setStatus(complaint.getStatus());
	        response.setCreatedAt(complaint.getCreatedAt());

	        return RegisterComplaintResponse.sucess(response);
	    }
	    
	}
	
	
