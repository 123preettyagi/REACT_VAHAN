package REACT_API.REACT.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import REACT_API.REACT.entity.FeedbackData;

@Repository
public interface FeedbackDataRepository
        extends JpaRepository<FeedbackData, Long> 
{

    Optional<FeedbackData>
    findByVehicleRegistrationNo(String vehicleRegistrationNo);

    Optional<FeedbackData>
    findByApplicationNumber(String applicationNumber); 
	
	
	 boolean existsByApplicationNumber(String applicationNumber);

	    boolean existsByChassisNumber(String chassisNumber);

	    boolean existsByVehicleRegistrationNo(String vehicleRegistrationNo);
	
}