package yadev.persona.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yadev.persona.entitys.Persona;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Long> {
}
