package com.babydevcode.services;

import com.babydevcode.entitys.Student;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

public interface StudentService {

    ResponseEntity<Object> getStudents(Integer page, Integer size, String name);

    ResponseEntity<String> deleteStudent(Long id);
}
