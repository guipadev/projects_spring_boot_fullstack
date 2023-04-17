package com.yadev.citas.services;

import com.yadev.citas.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Appointment extends JpaRepository<Appointment, String> {
}
