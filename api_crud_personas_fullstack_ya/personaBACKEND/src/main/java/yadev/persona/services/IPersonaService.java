package yadev.persona.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import yadev.persona.entitys.Persona;

import java.util.List;
import java.util.Optional;

public interface IPersonaService {

    List<Persona> findAll();

    List<Persona> findAll(Sort sort);

    Page<Persona> findAll(Pageable pageable);

    <S extends Persona> S save(S entity);

    Optional<Persona> findById(Long id);

    void deleteById(Long id);

    void delete(Persona entity);
}
