package xyz.yadev.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.yadev.crud.model.Student;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {
}
