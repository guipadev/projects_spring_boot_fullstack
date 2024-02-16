package co.sd.commons;

import java.io.Serializable;
import java.util.List;

/**
 * Se va a replicar como el proceso de CrudRepository
 * T entidad o Tipo, para este caso seria Persona
 */
public interface GenericService<T, ID extends Serializable> {

    // Método de Guardar
    T save(T entity);

    // Método de Borrar
    void delete(ID id);

    // Método de Obtener por el ID
    T get(ID id);

    // Método de Listar todos
    List<T> getAll();
}
