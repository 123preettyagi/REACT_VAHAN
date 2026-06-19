package REACT_API.REACT.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import REACT_API.REACT.dto.AppointmentRequest;
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
}