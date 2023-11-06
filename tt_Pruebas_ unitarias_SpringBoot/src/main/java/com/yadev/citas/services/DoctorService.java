package com.yadev.citas.services;

import com.yadev.citas.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorService extends JpaRepository<Doctor, String> {
}
