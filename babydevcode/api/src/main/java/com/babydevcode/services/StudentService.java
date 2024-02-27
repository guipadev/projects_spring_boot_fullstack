package com.babydevcode.services;

import com.babydevcode.entitys.Student;
import org.springframework.data.domain.Page;

public interface StudentService {

    Page<Student> getStudents(Integer page, Integer size, String name);
}
