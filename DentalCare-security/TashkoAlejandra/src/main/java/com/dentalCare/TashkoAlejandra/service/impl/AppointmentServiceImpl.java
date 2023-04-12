package com.dentalCare.TashkoAlejandra.service.impl;

import com.dentalCare.TashkoAlejandra.exception.ResourceNotFoundException;
import com.dentalCare.TashkoAlejandra.model.Appointment;
import com.dentalCare.TashkoAlejandra.model.Dentist;
import com.dentalCare.TashkoAlejandra.model.Patient;
import com.dentalCare.TashkoAlejandra.repository.AppointmentRepository;
import com.dentalCare.TashkoAlejandra.repository.DentistRepository;
import com.dentalCare.TashkoAlejandra.repository.PatientRepository;
import com.dentalCare.TashkoAlejandra.service.AppointmentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DentistRepository dentistRepository;
    @Override
    public Optional<Appointment> findAppointmentById(Long id) throws ResourceNotFoundException {

        if (appointmentRepository.findById(id).isPresent()){
            return Optional.of(appointmentRepository.findById(id).get());
        }
        return Optional.empty();
    }
    @Override
    public Appointment setAppointment(Appointment appointment) {
        Optional<Dentist> dentist = dentistRepository.findById(appointment.getDentist().getId());
        Optional<Patient> patient = patientRepository.findById(appointment.getPatient().getId());

        appointment.setDentist(dentist.get());
        appointment.setPatient(patient.get());

        appointment.setDate(new Date());
        LOGGER.info("Appointment has been successfully scheduled");
        return appointmentRepository.save(appointment);
    }
    @Override
    public String cancelAppointment(Long id) {

        if(appointmentRepository.findById(id).isPresent()){
            appointmentRepository.deleteById(id);
            LOGGER.info("Appointment deleted");
            return "The appointment has been successfully cancelled";
        }
        return "Appointment was not found";
    }
}
