package dev.guipa.crud.controller;

import dev.guipa.crud.model.DTO.StudentDTO;
import dev.guipa.crud.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    // GUARDAR
    @PostMapping
    public ResponseEntity<StudentDTO> saveStudent (@Validated @RequestBody StudentDTO studentDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.saveStudent(studentDTO));
    }

    // LISTAR PAGINACION
    @GetMapping
    public ResponseEntity<Page<StudentDTO>> getAllStudent (
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size,
            @RequestParam(required = false, defaultValue = "false") Boolean enablePagination
    ) {
        return ResponseEntity.ok(studentService.getAllStudent(page, size, enablePagination));
    }

    // ELIMINAR POR ID
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> deleteStudent(@PathVariable ("id") Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok(!studentService.existById(id));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<StudentDTO>> findStudentById(@PathVariable ("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.findById(id));
    }

    // EDITAR
    @PutMapping
    public ResponseEntity<StudentDTO> editStudent (@Validated @RequestBody StudentDTO studentDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.editStudent(studentDTO));
    }
}
