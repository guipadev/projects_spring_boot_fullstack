package co.yadev.libro.repository;

import co.yadev.libro.model.Libro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@Repository
// Ruta acceder API, ya se puede probar en postman GET, POST y demas
@RepositoryRestResource(path = "libros", collectionResourceRel = "libros")
public interface LibroRepository extends CrudRepository<Libro, Integer> {
}
