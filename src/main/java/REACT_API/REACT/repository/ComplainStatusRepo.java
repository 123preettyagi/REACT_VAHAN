package REACT_API.REACT.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import REACT_API.REACT.entity.ComplainStatus;



@Repository
public interface ComplainStatusRepo extends JpaRepository<ComplainStatus,Long>
{
	Optional<ComplainStatus> findByRequestId(String requestId);
	//boolean existByRequestId(String requestId);
	boolean existsByRequestId(String requestId);
	 
}