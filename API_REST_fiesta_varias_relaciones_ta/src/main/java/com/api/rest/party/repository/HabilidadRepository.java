package com.api.rest.party.repository;

import com.api.rest.party.entitys.Habilidad;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface HabilidadRepository extends CrudRepository<Habilidad, Long> {

    Collection<Habilidad> findAll();
}
