package co.sd.services.impl;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import co.sd.commons.GenericServiceImpl;
import co.sd.models.Persona;
import co.sd.repositorys.PersonaRepository;
import co.sd.services.PersonaService;
import lombok.RequiredArgsConstructor;

/**
 * Cuando invoquemos un método de nuestro dao(repository)
 * Realmente invocara un método de GenericServiceImpl
 * Y como el valor de dicho dao(repository)
 */
@RequiredArgsConstructor
@Service
public class PersonaServiceImpl extends GenericServiceImpl<Persona, Long> implements PersonaService {

    private final PersonaRepository personaRepository;

    @Override
    public CrudRepository<Persona, Long> getDao() {
        return personaRepository;
    }

}
