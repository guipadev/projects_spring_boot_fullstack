package yadev.persona.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yadev.persona.entitys.Pais;

@Repository
public interface IPaisRepository extends JpaRepository<Pais, Long> {
}
