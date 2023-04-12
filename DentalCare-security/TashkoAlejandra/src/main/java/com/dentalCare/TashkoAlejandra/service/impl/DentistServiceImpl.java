package com.dentalCare.TashkoAlejandra.service.impl;

import com.dentalCare.TashkoAlejandra.exception.ResourceNotFoundException;
import com.dentalCare.TashkoAlejandra.model.Dentist;
import com.dentalCare.TashkoAlejandra.model.DentistDto;
import com.dentalCare.TashkoAlejandra.repository.DentistRepository;
import com.dentalCare.TashkoAlejandra.service.DentistService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class DentistServiceImpl implements DentistService {

    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private DentistRepository dentistRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public Iterable<Dentist> findAllDentists() {
        Iterable<Dentist> dentists = null;
        dentists = dentistRepository.findAll();
        return dentists;
    }

    @Override
    public Optional<Dentist> findDentistById(Long id) throws ResourceNotFoundException {
        if (dentistRepository.findById(id).isPresent()) {
            LOGGER.info("Id" + id + "has been found");
            return Optional.of(dentistRepository.findById(id).get());
        } else {
            LOGGER.error("Dentist couldn't be found");
            return Optional.empty();
        }
    }

    // TODO:Optional
    @Override
    public Dentist createDentists(Dentist dentistNew) {
        System.out.println(dentistNew);
        if (dentistNew != null) {
            LOGGER.info("Patient created on database");
            dentistRepository.save(dentistNew);
        }
        return dentistNew;
    }

    @Override
    public String deleteDentist(Long id) throws ResourceNotFoundException {
        if (dentistRepository.findById(id).isPresent()) {
            dentistRepository.deleteById(id);
            LOGGER.info("Registered dentist deleted");
            return "The dentist has been successfully deleted";
        }
        return "Dentist was not found.";
    }

    @Override
    public boolean updateDentist(Dentist dentistUpdated, Long id) {
        return false;
    }


    @Override
    public DentistDto getDentists(Long Id) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public void createDentist(DentistDto dentist) {
        Dentist newDentist = mapper.convertValue(dentist, Dentist.class);
        dentistRepository.save(newDentist);}

}

