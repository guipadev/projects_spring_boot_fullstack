package com.babydevcode.services.impl;

import com.babydevcode.entitys.Student;
import com.babydevcode.repositorys.StudentRepository;
import com.babydevcode.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService  {

    private final StudentRepository studentRepository;


    @Override
    public Page<Student> getStudents(Integer page, Integer size, String name) {
        Pageable pageable = PageRequest.of(page, size);

        if (name.isEmpty()) {
            //Page<Student> listStudents = studentRepository.findAll(pageable);
            //return listStudents;
            return studentRepository.findAll(pageable);
        } else {
            //Page<Student> listSearch = studentRepository.findByNameContaining(name, pageable);
            //return listSearch;
            return studentRepository.findByNameContaining(name, pageable);
        }


    }

    @Override
    public String deleteStudent(Long id) {
        Boolean studentExist = studentRepository.findById(id).isPresent();

        String message = studentExist ? "Estudiante eliminado" : "Estudiante ID " + id + " no existe";

        if (studentExist) {
            studentRepository.deleteById(id);
        }

        return message;
    }

}
