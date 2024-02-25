package com.babydevcode.repositorys;

import com.babydevcode.entitys.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public class StudentRepository extends JpaRepository<Student, Long> {
}
