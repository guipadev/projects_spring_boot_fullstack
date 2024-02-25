package com.babydevcode.controllers;

import com.babydevcode.entitys.Student;
import com.babydevcode.services.impl.StudentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RequiredArgsConstructor
@RestController
public class StudentController {

    private final StudentServiceImpl studentService;

    @GetMapping("/students")
    public List<Student> findAllStudents() {
        return studentService.getStudents();
    }
}
