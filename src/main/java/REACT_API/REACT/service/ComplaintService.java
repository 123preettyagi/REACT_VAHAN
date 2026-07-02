package REACT_API.REACT.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import REACT_API.REACT.dto.ComplaintRequest;
import REACT_API.REACT.entity.FeedbackData;
import REACT_API.REACT.entity.VahanComplaint;
import REACT_API.REACT.repository.FeedbackDataRepository;
import REACT_API.REACT.repository.VahanComplaintRepository;

@Service
public class ComplaintService {

    private final FeedbackDataRepository feedbackRepo;
    private final VahanComplaintRepository complaintRepo;

    // Constructor Injection (Without Lombok)
    public ComplaintService(FeedbackDataRepository feedbackRepo,
                            VahanComplaintRepository complaintRepo) {
        this.feedbackRepo = feedbackRepo;
        this.complaintRepo = complaintRepo;
    }

    public Map<String, Object> submitComplaint(
            ComplaintRequest request,
            MultipartFile image) throws IOException {
    	
    	/* // Screenshot validation
        if (image == null || image.isEmpty()) {
            throw new RuntimeException("Screenshot is required");
        }
    	 */
        // REMOVED: Search Type condition - Always use VEHICLE search
        // Since your form collects vehicle registration and chassis number
        
    	FeedbackData feedbackData;

    	if (request.getVehicleRegistrationNo() != null
    	        && !request.getVehicleRegistrationNo().trim().isEmpty()) {

    	    feedbackData = feedbackRepo
    	            .findByVehicleRegistrationNo(request.getVehicleRegistrationNo())
    	            .orElseThrow(() ->
    	                    new RuntimeException(
    	                            "Vehicle not found with registration number: "
    	                                    + request.getVehicleRegistrationNo()));

    	} else if (request.getApplicationNo() != null
    	        && !request.getApplicationNo().trim().isEmpty()) {

    	    feedbackData = feedbackRepo
    	            .findByApplicationNumber(request.getApplicationNo())
    	            .orElseThrow(() ->
    	                    new RuntimeException(
    	                            "Application not found: "
    	                                    + request.getApplicationNo()));

    	} else {

    	    throw new RuntimeException(
    	            "Either Vehicle Registration Number or Application Number is required");
    	}

        // Validate chassis number (last 5 characters)
        String chassisNumber = feedbackData.getChassisNumber();

        if (chassisNumber == null || chassisNumber.length() < 5) {
            throw new RuntimeException("Invalid chassis number in database");
        }

        String last5Chars = chassisNumber.substring(chassisNumber.length() - 5);

        if (!last5Chars.equalsIgnoreCase(request.getChassisNumber())) {
            throw new RuntimeException("Chassis number validation failed. Last 5 characters do not match.");
        }
        
        
     // =========================
     // Validate State
     // =========================
     if (feedbackData.getState() == null ||
         !feedbackData.getState().trim().equalsIgnoreCase(request.getState().trim())) {
         throw new RuntimeException("State does not match the vehicle details.");
     }

     // =========================
     // Validate RTO Name
     // =========================
     if (feedbackData.getRtoName() == null ||
         !feedbackData.getRtoName().trim().equalsIgnoreCase(request.getRtoName().trim())) {
         throw new RuntimeException("RTO Name does not match the vehicle details.");
     }
        

        // Handle image upload 
        String imagePath = "";
        if (image != null && !image.isEmpty()) {
            String fileName = UUID.randomUUID() + "_" + image.getOriginalFilename();
            Path uploadPath = Paths.get("uploads");
            Files.createDirectories(uploadPath);
            Files.copy(
                    image.getInputStream(),
                    uploadPath.resolve(fileName),
                    StandardCopyOption.REPLACE_EXISTING);
            imagePath = "uploads/" + fileName;
        }

        
      
        // Create and save complaintZ
        VahanComplaint complaint = new VahanComplaint();
        complaint.setFeedbackDescription(request.getFeedbackDescription());
        complaint.setChassisNumber(request.getChassisNumber());
        complaint.setState(request.getState());
        complaint.setRtoName(request.getRtoName());
        complaint.setTransactionPurpose(request.getTransactionPurpose());
        complaint.setImagePath(imagePath);
        complaint.setCreatedAt(LocalDateTime.now());
        
        
        if (request.getVehicleRegistrationNo() != null &&
        	    !request.getVehicleRegistrationNo().isBlank()) {

        	    complaint.setVehicleRegistrationNo(
        	            request.getVehicleRegistrationNo());

        	    complaint.setApplicationNo(null);

        	} else {

        		complaint.setVehicleRegistrationNo("");  // <-- HERE
        	    complaint.setApplicationNo(
        	            request.getApplicationNo());
        	}

        
        
        VahanComplaint savedComplaint = complaintRepo.save(complaint);

        // Return JSON response
        Map<String, Object> response = new HashMap<>();
        response.put("status", "SUCCESS");
        response.put("message", "Complaint Submitted Successfully");
        response.put("complaintId", savedComplaint.getId());
        response.put("vehicleRegistrationNo", savedComplaint.getVehicleRegistrationNo());
        response.put("submittedAt", savedComplaint.getCreatedAt().toString());

        return response;
    }
}