package co.sd.commons;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 * Creación de nuestro servicio generico
 * Teniendo en cuenta que debemos asignar el dao(repository) sobre el cual
 * estamos trabajando en este caso de acuerdo al método abstracto => getDao()
 *
 * Si tenemos varios servicios, solo debemos extender de esta clase para tener
 * las funcionalidades básicas CRUD
 */
@Service
public abstract class GenericServiceImpl<T, ID extends Serializable> implements GenericService<T, ID> {

    @Override
    public T save(T entity) {
        return getDao().save(entity);
    }

    @Override
    public void delete(ID id) {
        getDao().deleteById(id);
    }

    @Override
    public T get(ID id) {
        Optional<T> obj = getDao().findById(id);

        if (obj.isPresent()) {
            return obj.get();
        }
        return null;
    }

    @Override
    public List<T> getAll() {
        List<T> returnList = new ArrayList<>();
        // En cada iteración, agrege al returnList el objeto como tal
        getDao().findAll().forEach(obj -> returnList.add(obj));

        return returnList;
    }

    /**
     * Método abstracto que nos permite cual es al repositorio que estamos pegando
     * Por ejemplo PersonaRepository, pero si tuvieramos más clases, necesitamos
     * saber
     * a que repository específicamente nosotros nos estamos comunicando
     */
    public abstract CrudRepository<T, ID> getDao();

}
