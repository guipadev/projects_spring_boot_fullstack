package co.guipadev.contactos.service;

import co.guipadev.contactos.entity.Contact;
import co.guipadev.contactos.entity.Phone;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * Interface para el servicio de Libreta
 */
public interface INotebookService {

    /** Devuelve una lista de Contactos con todos contactos del sistema */
    public List<Contact> getList();

    /**
     * Devuelve una lista de Contactos con todos contactos del sistema ordenados por el campo indicado
     * (nombre o apellido) ya sea ascendente o descendente
     *
     * @param field campo por el cual ordenar
     * @param order método de ordenado ASC o DESC
     * @return Lista de contactos
     */
    public List<Contact> getList(String field, Sort.Direction order);

    /**
     * Busca un dato dado entre el nombre y/o los apellidos en un contacto
     * @param dataToSearch Dato a buscar
     * @return Lita de contactos
     */
    public List<Contact> searchContacto(String dataToSearch);

    /**
     * Crea un contacto en el sistema
     *
     * @param contacto Objeto del contacto a crear
     * @return Objeto del contacto creado
     */
    public Contact createContacto(Contact contacto);

    /**
     * Crea un teléfono en el sistema a nombre de un contacto
     * @param telefono Objeto del teléfono a crear
     * @return Objeto del teléfono creado
     */
    public Phone createTelefono(Phone telefono);

    /**
     * Actualiza una tupla completa de un contacto
     * @param id Identificador del contacto a actualizar
     * @param contacto Objeto del contacto a actualizar
     * @return Objeto del contacto actualizado
     */
    Contact updateContacto(Integer id, Contact contacto);

    /**
     * Actualiza el nombre de un contacto basado en su identificador
     * @param id Identificador del contacto a actualizar
     * @param contacto Objeto del contacto a actualizar
     * @return Objeto del contacto actualizado
     */
    public Contact updateNombre(Integer id, Contact contacto);

    /**
     * Actualiza el apellido de un contacto basado en su identificador
     * @param id Identificador del contacto a actualizar
     * @param contacto Objeto del contacto a actualizar
     * @return Objeto del contacto actualizado
     */
    public Contact updateApellidos(Integer id, Contact contacto);

    /**
     * Actualiza la tupla completa de un teléfono en el sistema basado en su identificador
     * @param id Identificador del teléfono a actualizar
     * @param telefono Objeto del teléfono a actualizar
     * @return Objeto del teléfono actualizado
     */
    public Phone updateTelefono(Integer id, Phone telefono);

    /**
     * Actualiza solamente el teléfono de un contacto a partir del ID de la tupla del teléfono
     * @param id Identificador del teléfono a actualizar
     * @param telefono Objeto del teléfono a actualizar
     * @return Objeto del teléfono actualizado
     */
    public Phone updateOnlyTelefono(Integer id, Phone telefono);

    /**
     * Borra un contacto del sistema basado en su identificador
     * @param id Identificación del contacto a borrar
     * @return Objeto del contacto borrado
     */
    Contact deleteContacto(Integer id);

    /**
     * Borra un teléfono del sistema basado en su identificador
     * @param id Identificación del teléfono a borrar
     * @return Objeto del teléfono borrado
     */
    Phone deleteTelefono(Integer id);
}
