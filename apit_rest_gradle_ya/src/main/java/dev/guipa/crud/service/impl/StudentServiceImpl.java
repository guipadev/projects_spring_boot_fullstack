package dev.guipa.crud.service.impl;

import dev.guipa.crud.mapper.StudentConverter;
import dev.guipa.crud.model.DTO.StudentDTO;
import dev.guipa.crud.model.Student;
import dev.guipa.crud.repository.IStudentRepository;
import dev.guipa.crud.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static dev.guipa.crud.mapper.StudentConverter.convertToDTO;
import static dev.guipa.crud.mapper.StudentConverter.convertToEntity;

@Service
public class StudentServiceImpl implements IStudentService {

    private final IStudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentDTO saveStudent(StudentDTO studentDTO) {
        Student student = convertToEntity(studentDTO);
        student = studentRepository.save(student);
        return convertToDTO(student);
    }

    @Override
    public Page<StudentDTO> getAllStudent(Integer page, Integer size, Boolean enablePagination) {
        Pageable pageable = enablePagination ? PageRequest.of(page, size) : Pageable.unpaged();
        Page<Student> studentPage = studentRepository.findAll(pageable);
        return studentPage.map(StudentConverter::convertToDTO);
    }


    @Override
    public Optional<StudentDTO> findById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.map(StudentConverter::convertToDTO);
    }


    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDTO editStudent(StudentDTO studentDTO) {
        if (studentDTO.getId() != null && studentRepository.existsById(studentDTO.getId())) {
            Student student = convertToEntity(studentDTO);
            student = studentRepository.save(student);
            return convertToDTO(student);
        }
        return null;
    }

    @Override
    public boolean existById(Long id) {
        return studentRepository.existsById(id);
    }
}
