package com.api.rest.instructor.repository;

import com.api.rest.instructor.entitys.InstructorDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorDetalleRepository extends JpaRepository<InstructorDetalle, Long> {
}
