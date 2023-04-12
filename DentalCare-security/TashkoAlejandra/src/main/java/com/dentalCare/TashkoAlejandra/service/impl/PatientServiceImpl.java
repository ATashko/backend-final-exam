package com.dentalCare.TashkoAlejandra.service.impl;

import com.dentalCare.TashkoAlejandra.exception.ResourceNotFoundException;
import com.dentalCare.TashkoAlejandra.model.Patient;
import com.dentalCare.TashkoAlejandra.model.PatientDto;
import com.dentalCare.TashkoAlejandra.repository.PatientRepository;
import com.dentalCare.TashkoAlejandra.service.PatientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PatientServiceImpl implements PatientService{
    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    ObjectMapper mapper;


    @Override
      public Collection<PatientDto> getAll() {
        List<Patient> allPatients = patientRepository.findAll();
        Set<PatientDto> allPatientsDto = new HashSet<PatientDto>();
        for (Patient patient : allPatients)
            allPatientsDto.add(mapper.convertValue(patient, PatientDto.class));

        return allPatientsDto;
    }

    @Override
    public void createPatient(PatientDto patient) {
        Patient newPatient = mapper.convertValue(patient, Patient.class);
        patientRepository.save(newPatient);}

    @Override
    public String deletePatient(Long id) throws ResourceNotFoundException {
        if(patientRepository.findById(id).isPresent()){
            patientRepository.deleteById(id);
            LOGGER.info("Registered patient deleted");
            return "The patient has been successfully deleted";
        }
        return "Patient was not found.";
    }

    @Override
    public void updatePatient(PatientDto patient) {

        savePatient(patient);
    }

    private void savePatient(PatientDto patientDto) {
        Patient newPatient = mapper.convertValue(patientDto, Patient.class);
        patientRepository.save(newPatient);
    }

    @Override
    public Optional<Patient> findPatientById(Long id) throws ResourceNotFoundException {
        if (patientRepository.findById(id).isPresent()) {
            LOGGER.info("Id" + id + "has been found");
            return Optional.of(patientRepository.findById(id).get());
        } else {
            LOGGER.error("Patient couldn't be found");
            return Optional.empty();
        }
    }

}
