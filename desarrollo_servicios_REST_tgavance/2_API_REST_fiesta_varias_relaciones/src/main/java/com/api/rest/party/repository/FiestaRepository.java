package com.api.rest.party.repository;

import com.api.rest.party.entitys.Fiesta;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface FiestaRepository extends CrudRepository<Fiesta, Long> {

    Collection<Fiesta> findAll();
}
