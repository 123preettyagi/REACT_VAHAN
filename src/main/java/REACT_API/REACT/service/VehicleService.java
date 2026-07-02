package REACT_API.REACT.service;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import REACT_API.REACT.dto.VehicleDTO;
import REACT_API.REACT.entity.Vehicle;
import REACT_API.REACT.repository.VehicleRepository;
import jakarta.transaction.Transactional;

@Service
public class VehicleService 
{

private static final Logger log=LoggerFactory.getLogger(VehicleService.class);
private final VehicleRepository vr;
	
//Constructor Injection
	public VehicleService(VehicleRepository vr)
	
	{
	this.vr=vr;	
	}
	
	@Transactional
	public VehicleDTO registerVehicle(VehicleDTO vd)
	
	{
		log.info("Registering new vehicle with registration number: {}",vd.getRegistrationNumber());
		
		if(vr.existsByRegistrationNumber(vd.getRegistrationNumber()))
		{
			throw new RuntimeException("Vehicle with registration number "
                    + vd.getRegistrationNumber() + " already exists");
		}
		
		if (vr.existsByChassisNumber(vd.getChassisNumber())) {
            throw new RuntimeException("Vehicle with chassis number "
                    + vd.getChassisNumber() + " already exists");
        }
		
		Vehicle vc= convertToEntity(vd);
		Vehicle savedVehicle=vr.save(vc);
		
		
		log.info("Vehicle registered successfully with ID: {}",savedVehicle.getId());
		
		return convertToDTO(savedVehicle);
		
	}
	
	
	
	 
	 private Vehicle convertToEntity(VehicleDTO dto) {
	        Vehicle vehicle = new Vehicle();
	        vehicle.setRegistrationNumber(dto.getRegistrationNumber());
	        vehicle.setChassisNumber(dto.getChassisNumber());
	        vehicle.setOwnerName(dto.getOwnerName());
	        vehicle.setMobileNumber(dto.getMobileNumber());
	        vehicle.setVehicleType(dto.getVehicleType());
	        vehicle.setFuelType(dto.getFuelType());
	        vehicle.setRegistrationDate(dto.getRegistrationDate());
	        vehicle.setRtoName(dto.getRtoName());
	        vehicle.setCreatedAt(LocalDate.now());
	        vehicle.setUpdatedAt(LocalDate.now());
	        return vehicle;
	    }

	    private VehicleDTO convertToDTO(Vehicle vehicle) {
	        VehicleDTO dto = new VehicleDTO();
	        dto.setId(vehicle.getId());
	        dto.setRegistrationNumber(vehicle.getRegistrationNumber());
	        dto.setChassisNumber(vehicle.getChassisNumber());
	        dto.setOwnerName(vehicle.getOwnerName());
	        dto.setMobileNumber(vehicle.getMobileNumber());
	        dto.setVehicleType(vehicle.getVehicleType());
	        dto.setFuelType(vehicle.getFuelType());
	        dto.setRegistrationDate(vehicle.getRegistrationDate());
	        dto.setRtoName(vehicle.getRtoName());
	        vehicle.setCreatedAt(LocalDate.now());
	        vehicle.setUpdatedAt(LocalDate.now());
	        return dto;
	    }
}
