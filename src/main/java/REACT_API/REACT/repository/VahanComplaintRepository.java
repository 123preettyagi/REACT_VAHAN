package REACT_API.REACT.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import REACT_API.REACT.entity.FeedbackData;
import REACT_API.REACT.entity.VahanComplaint;

@Repository
public interface VahanComplaintRepository
        extends JpaRepository<VahanComplaint, Long> 
{


    
  
	
}