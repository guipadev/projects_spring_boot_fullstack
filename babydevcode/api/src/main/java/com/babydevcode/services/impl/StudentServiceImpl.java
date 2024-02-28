package com.babydevcode.services.impl;

import com.babydevcode.entitys.Student;
import com.babydevcode.repositorys.StudentRepository;
import com.babydevcode.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService  {

    private final StudentRepository studentRepository;


    @Override
    public ResponseEntity<Object> getStudents(Integer page, Integer size, String name) {
        Pageable pageable = PageRequest.of(page, size);

        if (name.isEmpty()) {
            Page<Student> listStudents = studentRepository.findAll(pageable);
            return new ResponseEntity<>(listStudents, HttpStatus.OK);
        } else {
            Page<Student> listSearch = studentRepository.findByNameContaining(name, pageable);

            if (listSearch.isEmpty()) {
                return new ResponseEntity<>(listSearch, HttpStatus.BAD_REQUEST);
            } else {
                return new ResponseEntity<>(listSearch, HttpStatus.OK);
            }
        }


    }

    @Override
    public ResponseEntity<String> deleteStudent(Long id) {
        boolean studentExist = studentRepository.findById(id).isPresent();

        if (studentExist) {
            studentRepository.deleteById(id);
            return new ResponseEntity<>("Estudiante eliminado correctamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Estudiante no existe", HttpStatus.BAD_REQUEST);
        }
    }


    @Override
    public ResponseEntity<String> createStudent(Student newStudent) {
        if (newStudent.getId() != null && studentRepository.existsById(newStudent.getId()) || studentRepository.existsByDni(newStudent.getDni())) {
            return new ResponseEntity<>("Estudiante ya existe", HttpStatus.BAD_REQUEST);
        }

        studentRepository.save(newStudent);
        return new ResponseEntity<>("Estudiante creado", HttpStatus.CREATED);
    }



}
