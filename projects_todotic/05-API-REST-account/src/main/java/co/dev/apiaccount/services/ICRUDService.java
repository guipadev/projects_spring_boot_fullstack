package co.dev.apiaccount.services;

import java.util.List;

public interface ICRUDService<T, ID> {
    // Obtener todos los datos
    public List<T> findAll();

    // Crear
    public T create(T o);

    // public T findbyId(ID id);
    // void delete(T o);
    // void deleteById(ID id);
    // public T update(T o);
}
