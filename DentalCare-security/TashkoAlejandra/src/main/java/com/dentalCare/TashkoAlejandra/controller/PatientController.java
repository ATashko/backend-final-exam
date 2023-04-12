package com.dentalCare.TashkoAlejandra.controller;

import com.dentalCare.TashkoAlejandra.exception.ResourceNotFoundException;
import com.dentalCare.TashkoAlejandra.model.Dentist;
import com.dentalCare.TashkoAlejandra.model.Patient;
import com.dentalCare.TashkoAlejandra.model.PatientDto;
import com.dentalCare.TashkoAlejandra.service.impl.PatientServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
public class PatientController {

    @Autowired
    PatientServiceImpl patientService;

    private static final Logger LOGGER = LogManager.getLogger();

    @PostMapping("/patient")
    public ResponseEntity<PatientDto> addPatient(@RequestBody PatientDto patient) {
        ResponseEntity response = null;
        patientService.createPatient(patient);
        return response = ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/patients")
    public Collection<PatientDto> listPatients() {
        return patientService.getAll();
    }

    @PutMapping("/update")
    public ResponseEntity<PatientDto> modifyStudent(@RequestBody PatientDto patientDto) {
        ResponseEntity response;
        patientService.updatePatient(patientDto);
        response = ResponseEntity.ok(HttpStatus.OK);
        return response;
    }

    @GetMapping("/patient/{id}")
    public Optional<Patient> getPatientById (@PathVariable Long id) throws ResourceNotFoundException {
        if(patientService.findPatientById(id).isPresent()){
            LOGGER.info("Id" + id + "has been found.");
            return Optional.of(patientService.findPatientById(id).get());}
        else{
            LOGGER.error("The id" + id + "doesn't exist.");
            return Optional.empty();
        }
    }

}
