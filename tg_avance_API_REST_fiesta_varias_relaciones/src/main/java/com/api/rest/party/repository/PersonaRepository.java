package com.api.rest.party.repository;

import com.api.rest.party.entitys.Persona;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface PersonaRepository extends CrudRepository<Persona, Long> {

    Collection<Persona> findAll();
}
