package xyz.yadev.persona.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.yadev.persona.model.Pais;

@Repository
public interface IPaisRepository extends JpaRepository<Pais, Long> {
}
