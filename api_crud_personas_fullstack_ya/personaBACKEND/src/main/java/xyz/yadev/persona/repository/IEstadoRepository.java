package xyz.yadev.persona.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.yadev.persona.model.Estado;

@Repository
public interface IEstadoRepository extends JpaRepository<Estado, Long> {
}
