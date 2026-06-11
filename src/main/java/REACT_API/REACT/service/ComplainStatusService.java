package REACT_API.REACT.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import REACT_API.REACT.entity.ComplainStatus;  
import REACT_API.REACT.dto.ComplainStatusResponse;
import REACT_API.REACT.repository.ComplainStatusRepo;
import REACT_API.REACT.util.TransactionNotFoundException;

@Service
public class ComplainStatusService 
{
	

	private final ComplainStatusRepo cmp;
	private static final Logger log=LoggerFactory.getLogger(ComplainStatusService.class);
	
	
	public ComplainStatusService(ComplainStatusRepo cmp) 
	{
	this.cmp=cmp;
		
	}
	
	public ComplainStatusResponse  getTransactionByRequestId(String requestId)
	{
		log.info("Fetching transaction for Request ID: {}",requestId);
		ComplainStatus complainstatus=cmp.findByRequestId(requestId)
				.orElseThrow(()-> new TransactionNotFoundException(
						 "Transaction not found for Request ID: " + requestId
						));
		return mapToResponse(complainstatus);
		
	}

	private ComplainStatusResponse mapToResponse(ComplainStatus complainstatus) {

		return ComplainStatusResponse.builder().
		requestId(complainstatus.getRequestId())
        .applicantName(complainstatus.getApplicationNumber())
        .vehicleNumber(complainstatus.getVehicleNumber())
        .serviceType(complainstatus.getServiceType())
        .amount(complainstatus.getAmount())
        .paymentStatus(complainstatus.getPaymentStatus())
        .transactionDate(complainstatus.getTransactionDate())
        .paymentMethod(complainstatus.getPaymentMethod())
        .referenceNumber(complainstatus.getRefrenceNumber())
        .message("Transaction found successfully")
        .success(true)
        .build();
		
		
	}
	
	

}
