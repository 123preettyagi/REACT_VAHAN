package REACT_API.REACT.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import REACT_API.REACT.entity.RegisterComplaint;

@Repository
public interface RegisterComplaintRepository extends JpaRepository<RegisterComplaint, Long> 
{
	 // Using indexes for better performance
    Optional<RegisterComplaint> findByVehicleNumber(String vehicleNumber);
    
    List<RegisterComplaint> findByEmail(String email);
    
    List<RegisterComplaint> findByStatus(String status);
    
   // @Query("SELECT c FROM Complaint c WHERE c.vehicleNumber = :vehicleNumber")
  //  Optional<RegisterComplaint> findComplaintByVehicleNumber(@Param("vehicleNumber") String vehicleNumber);
    
    boolean existsByVehicleNumber(String vehicleNumber);
	

}
