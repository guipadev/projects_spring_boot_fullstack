package yadev.persona.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yadev.persona.entitys.Estado;

@Repository
public interface IEstadoRepository extends JpaRepository<Estado, Long> {
}
