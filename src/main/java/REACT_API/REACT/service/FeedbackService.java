package REACT_API.REACT.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import REACT_API.REACT.dto.FeedbackRequest;
import REACT_API.REACT.entity.FeedbackData;
import REACT_API.REACT.repository.FeedbackDataRepository;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackDataRepository feedbackRepository;

    public FeedbackData saveFeedback(FeedbackRequest request) 
    {
    	
    	
    	 if (feedbackRepository.existsByApplicationNumber(
                 request.getApplicationNumber())) {
             throw new RuntimeException(
                 "Application Number already exists");
         }

         if (feedbackRepository.existsByChassisNumber(
                 request.getChassisNumber())) {
             throw new RuntimeException(
                 "Chassis Number already exists");
         }

         if (feedbackRepository.existsByVehicleRegistrationNo(
                 request.getVehicleRegistrationNo())) {
             throw new RuntimeException(
                 "Vehicle Registration Number already exists");
         }


        FeedbackData feedback = new FeedbackData();

        feedback.setApplicationNumber(request.getApplicationNumber());
        feedback.setChassisNumber(request.getChassisNumber());
        feedback.setEmailId(request.getEmailId());
        feedback.setVehicleRegistrationNo(request.getVehicleRegistrationNo());
        feedback.setRtoName(request.getRtoName());
        feedback.setState(request.getState());

        return feedbackRepository.save(feedback);
    }
}