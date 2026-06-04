package REACT_API.REACT.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import REACT_API.REACT.entity.Receipt;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, Long> {
    Optional<Receipt> findByReceiptNumberAndRegistrationNumber(String receiptNumber, String registrationNumber);
    Optional<Receipt> findByReceiptNumber(String receiptNumber);
}