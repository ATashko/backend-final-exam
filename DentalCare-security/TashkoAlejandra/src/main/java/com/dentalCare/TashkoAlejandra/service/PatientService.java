package com.dentalCare.TashkoAlejandra.service;

import com.dentalCare.TashkoAlejandra.exception.ResourceNotFoundException;
import com.dentalCare.TashkoAlejandra.model.Dentist;
import com.dentalCare.TashkoAlejandra.model.Patient;
import com.dentalCare.TashkoAlejandra.model.PatientDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public interface PatientService {

    Collection<PatientDto> getAll();

    void createPatient(PatientDto patient);

    String deletePatient(Long id) throws ResourceNotFoundException;

    void updatePatient(PatientDto patient);

    Optional<Patient> findPatientById(Long id) throws ResourceNotFoundException;
}
