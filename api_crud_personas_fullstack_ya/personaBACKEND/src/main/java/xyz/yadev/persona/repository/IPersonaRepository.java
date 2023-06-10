package xyz.yadev.persona.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.yadev.persona.model.Persona;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Long> {
}
