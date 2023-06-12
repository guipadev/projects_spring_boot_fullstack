package yadev.persona.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import yadev.persona.entitys.Persona;
import yadev.persona.repositorys.IPersonaRepository;
import yadev.persona.services.IPersonaService;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements IPersonaService {

    private final IPersonaRepository personaRepository;

    @Autowired
    public PersonaServiceImpl(IPersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Override
    public List<Persona> findAll() {
        return personaRepository.findAll();
    }

    @Override
    public List<Persona> findAll(Sort sort) {
        return personaRepository.findAll(sort);
    }

    @Override
    public Page<Persona> findAll(Pageable pageable) {
        return personaRepository.findAll(pageable);
    }

    @Override
    public <S extends Persona> S save(S entity) {
        return personaRepository.save(entity);
    }

    @Override
    public Optional<Persona> findById(Long id) {
        return personaRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        personaRepository.deleteById(id);
    }

    @Override
    public void delete(Persona entity) {
        personaRepository.delete(entity);
    }
}