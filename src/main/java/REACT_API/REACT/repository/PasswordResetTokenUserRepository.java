package REACT_API.REACT.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import REACT_API.REACT.entity.PasswordResetToken;
import REACT_API.REACT.entity.User;

@Repository
public interface PasswordResetTokenUserRepository extends JpaRepository<PasswordResetToken, Long> 
{

	  Optional<PasswordResetToken> findByToken(String token);
	  Optional<PasswordResetToken> findByUser(User user);
	    void deleteByUser(User user);	
	
	   
}
