package xyz.yadev.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import xyz.yadev.crud.model.Student;
import xyz.yadev.crud.service.StudentService;

import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // GUARDAR
    @PostMapping
    public ResponseEntity<Student> saveStudent (@Validated @RequestBody Student student) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.saveStudent(student));
    }

    // LISTAR PAGINACION
    @GetMapping
    public ResponseEntity<Page<Student>> getAllStudent (
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size,
            @RequestParam(required = false, defaultValue = "false") Boolean enablePagination
    ) {
        return ResponseEntity.ok(studentService.getAllStudent(page, size, enablePagination));
    }

    // ELIMINAR POR ID
    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteStudent(@PathVariable ("id") Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok(!studentService.existById(id));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Student>> findStudentById(@PathVariable ("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.findById(id));
    }

    // EDITAR
    @PutMapping
    public ResponseEntity<Student> editStudent (@Validated @RequestBody Student student){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.editStudent(student));
    }
}
