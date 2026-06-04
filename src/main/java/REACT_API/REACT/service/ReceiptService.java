package REACT_API.REACT.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import REACT_API.REACT.dto.ReceiptRequest;
import REACT_API.REACT.dto.ReceiptResponse;
import REACT_API.REACT.entity.Receipt;
import REACT_API.REACT.repository.ReceiptRepository;

@Service
public class ReceiptService {
    
    @Autowired
    private ReceiptRepository receiptRepository;
    
    public ReceiptResponse verifyReceipt(ReceiptRequest request) {
        Receipt receipt = receiptRepository
                .findByReceiptNumberAndRegistrationNumber(request.getReceiptNumber(), request.getRegistrationNumber())
                .orElseThrow(() -> new RuntimeException("Receipt not found"));
        
        return new ReceiptResponse(
            receipt.getReceiptNumber(),
            receipt.getRegistrationNumber(),
            receipt.getStatus(),
            receipt.getVehicleNumber()
        );
    }
    
    public ReceiptResponse getReceiptByNumber(String receiptNumber) {
        Receipt receipt = receiptRepository
                .findByReceiptNumber(receiptNumber)
                .orElseThrow(() -> new RuntimeException("Receipt not found"));
        
        return new ReceiptResponse(
            receipt.getReceiptNumber(),
            receipt.getRegistrationNumber(),
            receipt.getStatus(),
            receipt.getVehicleNumber()
        );
    }
}