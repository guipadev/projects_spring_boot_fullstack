package co.dev.tarea.repository;

import co.dev.tarea.model.Tarea;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TareaRepository extends MongoRepository<Tarea, String> {
}
