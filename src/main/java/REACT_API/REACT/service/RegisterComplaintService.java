package REACT_API.REACT.service;


import org.springframework.stereotype.Service;

import REACT_API.REACT.dto.RegisterComplaintRequest;
import REACT_API.REACT.dto.RegisterComplaintResponse;

@Service
public interface RegisterComplaintService 
{
	RegisterComplaintResponse registerComplaint(RegisterComplaintRequest request);
	RegisterComplaintResponse getComplaintByVehicleNumber(String vehicleNumber);
	
	
	
}
