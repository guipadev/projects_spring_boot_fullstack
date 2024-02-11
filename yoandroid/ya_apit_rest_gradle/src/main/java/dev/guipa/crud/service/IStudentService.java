package dev.guipa.crud.service;

import dev.guipa.crud.model.DTO.StudentDTO;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface IStudentService {

    StudentDTO saveStudent(StudentDTO studentDTO);

    Page<StudentDTO> getAllStudent(Integer page, Integer size, Boolean enablePagination);

    Optional<StudentDTO> findById(Long id);

    void deleteStudent(Long id);

    StudentDTO editStudent(StudentDTO studentDTO);

    boolean existById(Long id);
}
