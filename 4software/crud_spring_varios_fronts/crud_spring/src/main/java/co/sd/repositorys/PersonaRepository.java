package co.sd.repositorys;

import org.springframework.data.repository.CrudRepository;

import co.sd.models.Persona;

public interface PersonaRepository extends CrudRepository<Persona, Long> {

}
