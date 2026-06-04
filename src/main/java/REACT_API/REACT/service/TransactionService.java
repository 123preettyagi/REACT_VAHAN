package REACT_API.REACT.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import REACT_API.REACT.dto.TransactionDTO;
import REACT_API.REACT.dto.TransactionSearchRequest;
import REACT_API.REACT.entity.Transaction;
import REACT_API.REACT.repository.TransactionRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {
    
    @Autowired
    private TransactionRepository transactionRepository;
    
    
    public TransactionDTO getTransactionByTransactionId(String transactionId) {
        Transaction transaction = transactionRepository.findByTransactionId(transactionId)
                .orElseThrow(() -> new RuntimeException("Transaction not found with ID: " + transactionId));
        return convertToDTO(transaction);
    } 
    
    
    
    public TransactionDTO getTransactionByPaymentId(String paymentId) {
        Transaction transaction = transactionRepository.findByPaymentId(paymentId)
                .orElseThrow(() -> new RuntimeException("Transaction not found with Payment ID: " + paymentId));
        return convertToDTO(transaction);
    }
    
    public TransactionDTO getTransactionByBankRefNo(String bankRefNo) {
        Transaction transaction = transactionRepository.findByBankRefNo(bankRefNo)
                .orElseThrow(() -> new RuntimeException("Transaction not found with Bank Ref No: " + bankRefNo));
        return convertToDTO(transaction);
    }
    
    public TransactionDTO getTransactionByGrnNo(String grnNo) {
        Transaction transaction = transactionRepository.findByGrnNo(grnNo)
                .orElseThrow(() -> new RuntimeException("Transaction not found with GRN No: " + grnNo));
        return convertToDTO(transaction);
    }
    
    public TransactionDTO getTransactionByRegistrationNo(String registrationNo) {
        Transaction transaction = transactionRepository.findByRegistrationNo(registrationNo)
                .orElseThrow(() -> new RuntimeException("Transaction not found with Registration No: " + registrationNo));
        return convertToDTO(transaction);
    }
    
    public List<TransactionDTO> searchTransactions(TransactionSearchRequest searchRequest) {
        List<Transaction> transactions = transactionRepository.searchTransactions(
                searchRequest.getTransactionId(),
                searchRequest.getPaymentId(),
                searchRequest.getBankRefNo(),
                searchRequest.getGsnNo(),
                searchRequest.getRegistrationNo()
        );
        
        if (transactions.isEmpty()) {
            throw new RuntimeException("No transactions found matching the search criteria");
        }
        
        return transactions.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    private TransactionDTO convertToDTO(Transaction transaction) {
        TransactionDTO dto = new TransactionDTO();
        dto.setId(transaction.getId());
        dto.setAmount(transaction.getAmount());
        dto.setApplicationNo(transaction.getApplicationNo());
        dto.setBankRefNo(transaction.getBankRefNo());
        dto.setCin(transaction.getCin());
        dto.setGrnNo(transaction.getGrnNo());
        dto.setPaymentConfDate(transaction.getPaymentConfDate());
        dto.setPaymentDate(transaction.getPaymentDate());
        dto.setPaymentGateway(transaction.getPaymentGateway());
        dto.setPaymentId(transaction.getPaymentId());
        dto.setRegistrationNo(transaction.getRegistrationNo());
        dto.setStatus(transaction.getStatus());
        dto.setStatusDescription(transaction.getStatusDescription());
        dto.setTransactionId(transaction.getTransactionId());
        dto.setVehicleNo(transaction.getVehicleNo());
        return dto;
    }
    
}