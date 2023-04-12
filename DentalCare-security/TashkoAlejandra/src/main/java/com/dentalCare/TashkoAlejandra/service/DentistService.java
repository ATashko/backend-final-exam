package com.dentalCare.TashkoAlejandra.service;

import com.dentalCare.TashkoAlejandra.exception.ResourceNotFoundException;
import com.dentalCare.TashkoAlejandra.model.Dentist;
import com.dentalCare.TashkoAlejandra.model.DentistDto;

import java.util.Optional;


public interface DentistService {
    Iterable<Dentist> findAllDentists();
    DentistDto getDentists(Long Id) throws ResourceNotFoundException;
    Optional<Dentist> findDentistById (Long id) throws ResourceNotFoundException;
    Dentist createDentists(Dentist dentistNew);
    String deleteDentist(Long id) throws ResourceNotFoundException;
    boolean updateDentist(Dentist dentistUpdated, Long id);

    void createDentist(DentistDto dentist);
}
