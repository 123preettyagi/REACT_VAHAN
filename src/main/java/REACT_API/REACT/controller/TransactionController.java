package REACT_API.REACT.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import REACT_API.REACT.dto.ApiResponse;
import REACT_API.REACT.dto.ComplainStatusResponse;
import REACT_API.REACT.dto.ComplaintRequest;
import REACT_API.REACT.dto.FeedbackRequest;
import REACT_API.REACT.dto.OtpRequest;
import REACT_API.REACT.dto.OtpVerifyRequest;
import REACT_API.REACT.dto.ReceiptRequest;
import REACT_API.REACT.dto.ReceiptResponse;
import REACT_API.REACT.dto.TransactionDTO;
import REACT_API.REACT.dto.TransactionSearchRequest;
import REACT_API.REACT.entity.FeedbackData;
import REACT_API.REACT.service.ComplainStatusService;
import REACT_API.REACT.service.ComplaintService;
import REACT_API.REACT.service.FeedbackService;
import REACT_API.REACT.service.OtpService;
import REACT_API.REACT.service.ReceiptService;
import REACT_API.REACT.service.TransactionService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController
{
    
	 // =====================================================
    //                TRANSACTION APIs
    // =====================================================	
		
    @Autowired
    private TransactionService transactionService;
    
    @Autowired
    private ComplaintService complaintService;
    
    
    @GetMapping("/transaction-id/{transactionId}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<TransactionDTO> getByTransactionId(@PathVariable String transactionId) {
        return ResponseEntity.ok(transactionService.getTransactionByTransactionId(transactionId));
    }
    
    @GetMapping("/payment-id/{paymentId}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<TransactionDTO> getByPaymentId(@PathVariable String paymentId) {
        return ResponseEntity.ok(transactionService.getTransactionByPaymentId(paymentId));
    }
    
    @GetMapping("/bank-ref/{bankRefNo}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<TransactionDTO> getByBankRefNo(@PathVariable String bankRefNo) {
        return ResponseEntity.ok(transactionService.getTransactionByBankRefNo(bankRefNo));
    }
    
    @GetMapping("/grn-no/{grnNo}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<TransactionDTO> getByGrnNo(@PathVariable String grnNo) {
        return ResponseEntity.ok(transactionService.getTransactionByGrnNo(grnNo));
    }
    
    @GetMapping("/registration-no/{registrationNo}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<TransactionDTO> getByRegistrationNo(@PathVariable String registrationNo) {
        return ResponseEntity.ok(transactionService.getTransactionByRegistrationNo(registrationNo));
    }
    
    @PostMapping("/search")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<List<TransactionDTO>> searchTransactions(@RequestBody TransactionSearchRequest searchRequest) {
        return ResponseEntity.ok(transactionService.searchTransactions(searchRequest));
    }
    
    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<TransactionDTO>> getAllTransactions() {
        // You can implement this method if needed
        return ResponseEntity.ok(null);
    }
    
    
    // =====================================================
    //                RECEIPT VERIFY API
    // =====================================================
    
    @Autowired
    private ReceiptService receiptService;

 // =====================================================
//  RECEIPT VERIFY API
//=====================================================

  @PostMapping("/verify-receipt")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
     public ResponseEntity<ReceiptResponse> verifyReceipt(
             @RequestBody ReceiptRequest request)
               {

         ReceiptResponse response = receiptService.verifyReceipt(request);

            return ResponseEntity.ok(response);
    
               }
  
  
  
  
  
//=====================================================
//FEEDBACK API
//=====================================================

@Autowired
private FeedbackService feedbackService;
  

@PreAuthorize("hasAnyRole('USER','ADMIN')")
@PostMapping("/save-feedback")
public ResponseEntity<FeedbackData> saveFeedback(
        @Valid @RequestBody FeedbackRequest request) {

    FeedbackData savedData =
            feedbackService.saveFeedback(request);

    return ResponseEntity.ok(savedData);
}
  
  
//=====================================================
//COMPLAINT API
//=====================================================

  @PostMapping(value = "/submit-complaint",
          consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  @PreAuthorize("hasAnyRole('USER','ADMIN')")
  public ResponseEntity<Map<String, Object>> submitComplaint(
		  @Valid ComplaintRequest request,
         @RequestParam(required = false) String vehicleRegistrationNo,
         @RequestParam(value = "applicationNo", required = false) String applicationNumber,
         @RequestParam String chassisNumber,
         @RequestParam String feedbackDescription,
         @RequestParam String rtoName,
         @RequestParam String state,
         @RequestParam String transactionPurpose, 
         @RequestParam("image") MultipartFile image)
    throws IOException 
  
  {
	  
	  System.out.println("Image received: " + image);
	    System.out.println("File name: " + image.getOriginalFilename());
	    System.out.println("File size: " + image.getSize());
	    
	    if (image == null || image.isEmpty()) {
	        throw new RuntimeException("Screenshot is required");
	    }
	    
    // ComplaintRequest request = new ComplaintRequest();

     request.setVehicleRegistrationNo(vehicleRegistrationNo);
     request.setApplicationNo(applicationNumber);
     request.setChassisNumber(chassisNumber);
     request.setFeedbackDescription(feedbackDescription);
     request.setRtoName(rtoName);
     request.setState(state);
     request.setTransactionPurpose(transactionPurpose);

     return ResponseEntity.ok(
             complaintService.submitComplaint(request, image));
  }
  
//=====================================================
//OTP APIs
//=====================================================
  
  
  @Autowired
  private OtpService otpService;

@PostMapping("/otp/send")
@PreAuthorize("hasAnyRole('USER','ADMIN')")
public ResponseEntity<ApiResponse> sendOtp(
       @RequestBody OtpRequest request) {

   try {

       if (request.getEmail() == null ||
           request.getEmail().isBlank()) {

           return ResponseEntity.badRequest()
                   .body(new ApiResponse(false,
                           "Email is required"));
       }

       otpService.sendOtp(request.getEmail());

       return ResponseEntity.ok(
               new ApiResponse(true,
                       "OTP sent successfully to "
                               + request.getEmail()));

   } catch (IllegalArgumentException e) {

       return ResponseEntity.badRequest()
               .body(new ApiResponse(false,
                       e.getMessage()));

   } catch (Exception e) {

       return ResponseEntity.status(
               HttpStatus.INTERNAL_SERVER_ERROR)
               .body(new ApiResponse(false,
                       "Failed to send OTP: "
                               + e.getMessage()));
   }
}


@PostMapping("/otp/verify")
@PreAuthorize("hasAnyRole('USER','ADMIN')")
public ResponseEntity<ApiResponse> verifyOtp(
       @RequestBody OtpVerifyRequest request) {

   try {

       if (request.getEmail() == null ||
           request.getOtp() == null) {

           return ResponseEntity.badRequest()
                   .body(new ApiResponse(false,
                           "Email and OTP are required"));
       }

       String result = otpService.verifyOtp(
               request.getEmail(),
               request.getOtp());

       return switch (result) {

           case "OTP_VERIFIED" ->
                   ResponseEntity.ok(
                           new ApiResponse(true,
                                   "OTP verified successfully"));

           case "OTP_EXPIRED" ->
                   ResponseEntity.status(HttpStatus.GONE)
                           .body(new ApiResponse(false,
                                   "OTP has expired"));

           case "OTP_INVALID" ->
                   ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                           .body(new ApiResponse(false,
                                   "Invalid OTP"));

           case "TOO_MANY_ATTEMPTS" ->
                   ResponseEntity.status(
                           HttpStatus.TOO_MANY_REQUESTS)
                           .body(new ApiResponse(false,
                                   "Too many failed attempts"));

           default ->
                   ResponseEntity.status(
                           HttpStatus.NOT_FOUND)
                           .body(new ApiResponse(false,
                                   "OTP not found"));
       };

   } catch (Exception e) {

       return ResponseEntity.status(
               HttpStatus.INTERNAL_SERVER_ERROR)
               .body(new ApiResponse(false,
                       "Verification failed: "
                               + e.getMessage()));
   }
}


//=====================================================
//COMPLAIN STATUS API
//=====================================================

@Autowired
private ComplainStatusService complainStatusService;

@GetMapping("/complainstatus/{requestId}")
@PreAuthorize("hasAnyRole('USER','ADMIN')")
public ResponseEntity<ComplainStatusResponse> getTransactionByRequestId(
        @PathVariable
        @NotBlank(message = "Request ID is required")
        @Pattern(
            regexp = "^[A-Za-z0-9/]+$",
            message = "Only alphabets, digits and / allowed"
        )
        String requestId)
{
    ComplainStatusResponse response =
            complainStatusService.getTransactionByRequestId(requestId);

    return ResponseEntity.ok(response);
}





}
    
