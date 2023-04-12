package com.dentalCare.TashkoAlejandra.controller;

import com.dentalCare.TashkoAlejandra.exception.ResourceNotFoundException;
import com.dentalCare.TashkoAlejandra.model.Dentist;
import com.dentalCare.TashkoAlejandra.model.DentistDto;
import com.dentalCare.TashkoAlejandra.service.DentistService;
import com.dentalCare.TashkoAlejandra.service.impl.DentistServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.OptionalDataException;
import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("/dentist")
public class DentistController {

    @Autowired
    public DentistServiceImpl dentistService;
    private static final Logger LOGGER = LogManager.getLogger();

    @GetMapping("/dentists")
    public Iterable<Dentist> getDentists() {

        return dentistService.findAllDentists();}

    //TODO:proponer una excepcion util.
    @GetMapping("/dentist/{id}")
    public Optional<Dentist> getDentistById (@PathVariable Long id) throws ResourceNotFoundException {
        if(dentistService.findDentistById(id).isPresent()){
            LOGGER.info("Id" + id + "has been found.");
            return Optional.of(dentistService.findDentistById(id).get());}
        else{
            LOGGER.error("The id" + id + "doesn't exist.");
            return Optional.empty();
        }
    }
    //TODO: borrar sout cuando realice los cambios en la implementacion del service y siga funcionando.
    //TODO: realizar cambio a optional si se necesita.
    @PostMapping("/dentist")
    public ResponseEntity<Dentist> addDentist (@RequestBody Dentist dentist){
        LOGGER.info("Dentist added");
        System.out.println("parametros en el controlador" + dentist );
        return ResponseEntity.ok(dentistService.createDentists(dentist));
    }

    @DeleteMapping("/dentist/{id}")
    public ResponseEntity deleteDentist(@PathVariable Long id) throws ResourceNotFoundException {
        ResponseEntity response= null;
        if(dentistService.findDentistById(id).isEmpty()){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }else{
            dentistService.deleteDentist(id);
            response = new ResponseEntity(HttpStatus.NO_CONTENT);
            LOGGER.info("Dentist has been deleted.");
        }
        return response;
    }
    //TODO: no funciona
    @PutMapping("/dentist/{id}")
    public ResponseEntity<Dentist> updateDentist(@PathVariable Long id, @RequestBody Dentist updatedDentist) throws ResourceNotFoundException {
        ResponseEntity response = null;
        if(dentistService.findDentistById(id).isEmpty()){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }else{
            dentistService.updateDentist(updatedDentist, id);
            response= new ResponseEntity(HttpStatus.OK);
        }
        return response;
    }

    /*@GetMapping("/dentistDto")
    public ResponseEntity<DentistDto> getDentist(Long Id){
        ObjectMapper objectMapper = new ObjectMapper();
        Dentist dentist = new Dentist();
        Optional<DentistDto> dentistDto = den
    }*/

}
