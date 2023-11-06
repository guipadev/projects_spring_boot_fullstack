package dev.guipa.crud.mapper;

import dev.guipa.crud.model.DTO.StudentDTO;
import dev.guipa.crud.model.Student;

public class StudentConverter {

    public static Student convertToEntity(StudentDTO studentDTO) {
        Student student = new Student();
        student.setId(studentDTO.getId());
        student.setName(studentDTO.getName());
        student.setLastName(studentDTO.getLastName());
        student.setAge(studentDTO.getAge());
        return student;
    }

    public static StudentDTO convertToDTO(Student student) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setName(student.getName());
        studentDTO.setLastName(student.getLastName());
        studentDTO.setAge(student.getAge());
        return studentDTO;
    }
}
