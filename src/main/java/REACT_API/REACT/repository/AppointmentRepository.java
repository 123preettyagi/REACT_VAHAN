package REACT_API.REACT.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import REACT_API.REACT.entity.Appointment;

@Repository
public interface AppointmentRepository
        extends JpaRepository<Appointment, Long> {

    @Query("""
           SELECT a
           FROM Appointment a
           WHERE LOWER(a.CustomerName) = LOWER(:customerName)
           """)
    List<Appointment> findByCustomerNameIgnoreCase(
            @Param("customerName") String customerName);
    
   
}