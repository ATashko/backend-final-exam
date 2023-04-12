package com.dentalCare.TashkoAlejandra.controller;

import com.dentalCare.TashkoAlejandra.model.Appointment;
import com.dentalCare.TashkoAlejandra.service.impl.AppointmentServiceImpl;
import com.dentalCare.TashkoAlejandra.service.impl.DentistServiceImpl;
import com.dentalCare.TashkoAlejandra.service.impl.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppointmentController {

    @Autowired
    AppointmentServiceImpl appointmentService;

    @Autowired
    DentistServiceImpl dentistService;

    @Autowired
    PatientServiceImpl patientService;



//TODO: No funciona.

/*    @PostMapping("/appointment")
    public ResponseEntity<Appointment> setAppointment(@RequestBody Appointment appointment){
        ResponseEntity<Appointment> response = null;
        if(dentistService.getDentists(appointment.getDentist())!=null &&
                patientService.getPatients(appointment.getPatient()) != null){
            response = ResponseEntity.ok(appointmentService.setAppointment(appointment));
        }else{
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } return response;
    }*/
}
