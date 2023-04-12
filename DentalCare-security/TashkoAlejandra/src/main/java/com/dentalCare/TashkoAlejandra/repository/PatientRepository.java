package com.dentalCare.TashkoAlejandra.repository;

import com.dentalCare.TashkoAlejandra.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository <Patient, Long> {
}
