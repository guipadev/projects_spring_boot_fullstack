package com.yadev.citas.services;

import com.yadev.citas.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientService extends JpaRepository<Patient, String> {
}
