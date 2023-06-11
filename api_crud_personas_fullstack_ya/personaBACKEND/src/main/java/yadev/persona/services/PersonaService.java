package yadev.persona.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import yadev.persona.entitys.Persona;
import yadev.persona.repositorys.IPersonaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    @Autowired
    private IPersonaRepository personaRepository;

    public List<Persona> findAll() {
        return personaRepository.findAll();
    }

    public List<Persona> findAll(Sort sort) {
        return personaRepository.findAll(sort);
    }

    public Page<Persona> findAll(Pageable pageable) {
        return personaRepository.findAll(pageable);
    }

    public <S extends Persona> S save(S entity) {
        return personaRepository.save(entity);
    }

    public Optional<Persona> findById(Long id) {
        return personaRepository.findById(id);
    }

    public void deleteById(Long id) {
        personaRepository.deleteById(id);
    }

    public void delet(Persona entity) {
        personaRepository.delete(entity);
    }


}
