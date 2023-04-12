package com.dentalCare.TashkoAlejandra.service;

import com.dentalCare.TashkoAlejandra.exception.ResourceNotFoundException;
import com.dentalCare.TashkoAlejandra.model.Appointment;
import com.dentalCare.TashkoAlejandra.model.Dentist;

import java.util.Optional;

public interface AppointmentService {

    Optional<Appointment> findAppointmentById (Long id) throws ResourceNotFoundException;

    Appointment setAppointment(Appointment appointment);

    String cancelAppointment(Long id);
}
