package com.dentalCare.TashkoAlejandra.repository;

import com.dentalCare.TashkoAlejandra.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository <Appointment, Long> {
}
