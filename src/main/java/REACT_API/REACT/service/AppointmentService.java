package REACT_API.REACT.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import REACT_API.REACT.dto.AppointmentRequest;
import REACT_API.REACT.dto.AppointmentResponse;
import REACT_API.REACT.dto.AppointmentSearchRequest;
import REACT_API.REACT.entity.Appointment;
import REACT_API.REACT.repository.AppointmentRepository;
import jakarta.transaction.Transactional;

@Service
public class AppointmentService {

    private static final Logger log =
            LoggerFactory.getLogger(AppointmentService.class);

    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Transactional
    public Appointment createAppointment(AppointmentRequest request) {

        log.info("Creating appointment for customer: {}",
                request.getCustomerName());

        Appointment appointment = new Appointment();

        appointment.setCustomerName(request.getCustomerName());
        appointment.setEmail(request.getEmail());
        appointment.setPhoneNumber(request.getPhoneNumber());
        appointment.setVehicleNumber(
                request.getVehicleNumber().toUpperCase());
        appointment.setVehicleType(request.getVehicleType());
        appointment.setServiceType(request.getServiceType());
        appointment.setPreferredDate(request.getPreferredDate());
        appointment.setPreferredTime(request.getPreferredTime());
        appointment.setAdditionalNotes(request.getAdditionalNotes());

        Appointment savedAppointment =
                appointmentRepository.save(appointment);

        log.info("Appointment created successfully with ID: {}",
                savedAppointment.getId());

        return savedAppointment;
    }
   
    @Transactional
    public List<AppointmentResponse> findAppointments(
            AppointmentSearchRequest request) {

        List<Appointment> appointments =
                appointmentRepository.findByCustomerNameIgnoreCase(
                        request.getCustomerName());

        return appointments.stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    private AppointmentResponse convertToResponse(Appointment appointment) {

        AppointmentResponse response = new AppointmentResponse();

        response.setId(appointment.getId());
        response.setCustomerName(appointment.getCustomerName());
        response.setEmail(appointment.getEmail());
        response.setPhoneNumber(appointment.getPhoneNumber());
        response.setVehicleNumber(appointment.getVehicleNumber());
        response.setVehicleType(appointment.getVehicleType());
        response.setServiceType(appointment.getServiceType());
        response.setPreferredDate(appointment.getPreferredDate());
        response.setPreferredTime(appointment.getPreferredTime());
        response.setAdditionalNotes(appointment.getAdditionalNotes());

        return response;
    }
   
    
}