package REACT_API.REACT.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import REACT_API.REACT.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    
    Optional<Transaction> findByTransactionId(String transactionId);
    
    Optional<Transaction> findByPaymentId(String paymentId);
    
    Optional<Transaction> findByBankRefNo(String bankRefNo);
    
    Optional<Transaction> findByGrnNo(String grnNo);
    
    Optional<Transaction> findByRegistrationNo(String registrationNo);
    
    @Query("SELECT t FROM Transaction t WHERE " +
           "(:transactionId IS NULL OR t.transactionId = :transactionId) AND " +
           "(:paymentId IS NULL OR t.paymentId = :paymentId) AND " +
           "(:bankRefNo IS NULL OR t.bankRefNo = :bankRefNo) AND " +
           "(:grnNo IS NULL OR t.grnNo = :grnNo) AND " +
           "(:registrationNo IS NULL OR t.registrationNo = :registrationNo)")
    List<Transaction> searchTransactions(@Param("transactionId") String transactionId,
                                         @Param("paymentId") String paymentId,
                                         @Param("bankRefNo") String bankRefNo,
                                         @Param("grnNo") String grnNo,
                                         @Param("registrationNo") String registrationNo);
}