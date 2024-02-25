package com.babydevcode.services.impl;

import com.babydevcode.entitys.Student;
import com.babydevcode.repositorys.StudentRepository;
import com.babydevcode.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService  {

    private final StudentRepository studentRepository;


    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

}
