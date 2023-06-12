package yadev.persona.services;

import org.springframework.data.domain.Sort;
import yadev.persona.entitys.Estado;

import java.util.List;

public interface IEstadoService {

    List<Estado> findAll();

    List<Estado> findAllByCountry(Long id);

    List<Estado> findAll(Sort sort);
}
