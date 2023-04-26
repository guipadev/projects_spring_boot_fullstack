package com.api.rest.instructor.controller;

import com.api.rest.instructor.entitys.Instructor;
import com.api.rest.instructor.excepciones.ResourceNotFoundException;
import com.api.rest.instructor.repository.InstructorDetalleRepository;
import com.api.rest.instructor.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class InstructorController {

    @Autowired
    private InstructorRepository instructorRepository;
    @Autowired
    private InstructorDetalleRepository instructorDetalleRepository;

    @GetMapping("/instructores")
    public List<Instructor> listarInstructores() {
        return instructorRepository.findAll();
    }

    @GetMapping("/instructores/{id}")
    public ResponseEntity<Instructor> verDetallesDelInstructor(@PathVariable Long id) {
        Instructor instructor = instructorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Instructor con el ID: " + id + " no se encuentra"));

        return ResponseEntity.ok().body(instructor);
    }

    @PostMapping("/instructores")
    public Instructor guardarInstructor(@Valid @RequestBody Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @PutMapping("/instrutores/{id}")
    public ResponseEntity<Instructor> actualizarInstructor(@PathVariable Long id, @Valid @RequestBody Instructor instructorDetalles) {
        Instructor instructor = instructorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Instructor con el ID : " + id + " no se encuentra"));

        instructor.setEmail(instructorDetalles.getEmail());

        Instructor instructorActualizado = instructorRepository.save(instructor);

        return ResponseEntity.ok(instructorActualizado);
    }

    @DeleteMapping("/instrutores/{id}")
    public Map<String, Boolean> eliminarInstructor(@PathVariable Long id) {
        Instructor instructor = instructorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Instructor con el ID : " + id + " no se encuentra"));

        instructorRepository.delete(instructor);

        Map<String, Boolean> respuesta = new HashMap<>();

        respuesta.put("Instructor eliminado", Boolean.TRUE);

        return respuesta;
    }

}
