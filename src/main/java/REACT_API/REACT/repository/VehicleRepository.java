package REACT_API.REACT.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import REACT_API.REACT.entity.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Long>
{

	Optional<Vehicle> findByRegistrationNumber(String registrationNumber);
	Optional<Vehicle> findByChassisNumber(String chassisNumber);
    List<Vehicle> findByOwnerNameContainingIgnoreCase(String ownerName);
    
    List<Vehicle> findByRtoName(String rtoName);
    
    List<Vehicle> findByVehicleType(String vehicleType);
    
    List<Vehicle> findByFuelType(String fuelType);
    
    List<Vehicle> findByRegistrationDateBetween(LocalDate startDate, LocalDate endDate);
    
    @Query("SELECT v FROM Vehicle v WHERE v.registrationNumber LIKE %:search% OR v.ownerName LIKE %:search%")
    List<Vehicle> searchVehicles(@Param("search") String search);
    
    boolean existsByRegistrationNumber(String registrationNumber);
    
    boolean existsByChassisNumber(String chassisNumber);
    

}
