package xyz.yadev.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import xyz.yadev.crud.model.Student;
import xyz.yadev.crud.repository.IStudentRepository;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private IStudentRepository iStudentRepository;

    // GUARDAR
    public Student saveStudent (Student student){
        if (student.getId() == null){
            return iStudentRepository.save(student);
        }
        return null;
    }

    // LISTAR PAGINACION
    public Page<Student> getAllStudent (Integer page, Integer size, Boolean enablePagination){
        return iStudentRepository.findAll(enablePagination ? PageRequest.of(page, size): Pageable.unpaged());
    }

    // BUSCAR POR ID, se pone Optional en caso de no exister estudiante en BD
    public Optional<Student> findById(Long id){
        return iStudentRepository.findById(id);
    }

    // ELIMINAR POR ID
    public void deleteStudent(Long id){
        iStudentRepository.deleteById(id);
    }


    // EDITAR
    public Student editStudent (Student student){
        if (student.getId() != null && iStudentRepository.existsById(student.getId())){
            return iStudentRepository.save(student);
        }
        return null;
    }

    public boolean existById(Long id) {
        return iStudentRepository.existsById(id);
    }
}
