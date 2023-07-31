package co.guipadev.contactos.service.Impl;

import co.guipadev.contactos.entity.Contact;
import co.guipadev.contactos.entity.Phone;
import co.guipadev.contactos.repository.ContactRepository;
import co.guipadev.contactos.repository.PhoneRepository;
import co.guipadev.contactos.service.INotebookService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;

/**
 * Clase tipo Servicio para el manejo de la libreta
 */
@Service
public class NotebookServiceImpl implements INotebookService {

    /** Repositorio de Contacto */
    @Autowired
    private ContactRepository contactoRepository;

    /** Repositorio de Telefono */
    @Autowired
    private PhoneRepository telefonoRepository;

    /** Devuelve una lista de Contactos con todos contactos del sistema */
    @Override
    @Transactional(readOnly = true)
    public List<Contact> getList() {
        return contactoRepository.findAll();
    }

    /**
     * Devuelve una lista de Contactos con todos contactos del sistema ordenados por el campo indicado
     * ya sea ascendente o descendete
     * @param field campo por el cual ordenar
     * @param order método de ordenado ASC o DESC
     * @return Lista de contactos
     */
    @Override
    @Transactional(readOnly = true)
    public List<Contact> getList(String field, Sort.Direction order) {
        return contactoRepository.findAll(Sort.by(order, field));
    }

    /**
     * Busca un dato entre el nombre o los apellidos en un contacto
     * @param dataToSearch Dato a buscar
     * @return Lita de contactos
     */
    @Override
    @Transactional(readOnly = true)
    public List<Contact> searchContacto(String dataToSearch) {
        var contacto1 = contactoRepository.findByNombreOrApellidoStartingWith(dataToSearch);
        var contacto2 = contactoRepository.findByNombreOrApellidoContains(dataToSearch);
        var contacto3 = contactoRepository.findByNombreOrApellidoEndingWith(dataToSearch);
        var answer = new HashSet<Contact>();
        answer.addAll(contacto1);
        answer.addAll(contacto2);
        answer.addAll(contacto3);
        return answer.stream().toList();
    }

    /**
     * Crea un contacto en el sistema
     * @param contacto Objeto del contacto a crear
     * @return Objeto del contacto creado
     */
    @Override
    @Transactional
    public Contact createContacto(Contact contacto) {
        contacto.setCreatedAt(Instant.now());
        return contactoRepository.save(contacto);
    }

    /**
     * Crea un teléfono en el sistema a nombre de un contacto
     *
     * @param telefono Objeto del teléfono a crear
     * @return Objeto del teléfono creado
     *
     * @author Julian Lasso <julian.lasso@sofka.com.co>
     * @since 1.0.0
     */
    @Override
    @Transactional
    public Phone createTelefono(Phone telefono) {
        telefono.setCreatedAt(Instant.now());
        return telefonoRepository.save(telefono);
    }

    /**
     * Actualiza una tupla completa de un contacto
     *
     * @param id Identificador del contacto a actualizar
     * @param contacto Objeto del contacto a actualizar
     * @return Objeto del contacto actualizado
     */
    @Override
    @Transactional
    public Contact updateContacto(Integer id, Contact contacto) {
        contacto.setId(id);
        contacto.setUpdatedAt(Instant.now());
        return contactoRepository.save(contacto);
    }

    /**
     * Actualiza el nombre de un contacto
     * @param id Identificador del contacto a actualizar
     * @param contacto Objeto del contacto a actualizar
     * @return Objeto del contacto actualizado
     */
    @Override
    @Transactional
    public Contact updateNombre(Integer id, Contact contacto) {
        contacto.setId(id);
        contacto.setUpdatedAt(Instant.now());
        contactoRepository.updateNombre(id, contacto.getNombre());
        return contacto;
    }

    /**
     * Actualiza el apellido de un contacto
     * @param id Identificador del contacto a actualizar
     * @param contacto Objeto del contacto a actualizar
     * @return Objeto del contacto actualizado
     */
    @Override
    @Transactional
    public Contact updateApellidos(Integer id, Contact contacto) {
        contacto.setId(id);
        contacto.setUpdatedAt(Instant.now());
        contactoRepository.updateApellido(id, contacto.getApellido());
        return contacto;
    }

    /**
     * Actualiza la tupla completa de un teléfono en el sistema
     * @param id Identificador del teléfono a actualizar
     * @param telefono Objeto del teléfono a actualizar
     * @return Objeto del teléfono actualizado
     */
    @Override
    @Transactional
    public Phone updateTelefono(Integer id, Phone telefono) {
        telefono.setId(id);
        telefono.setUpdatedAt(Instant.now());
        telefonoRepository.save(telefono);
        return telefono;
    }

    /**
     * Actualiza solamente el teléfono de un contacto a partir del ID de la tupla del teléfono
     * @param id Identificador del teléfono a actualizar
     * @param telefono Objeto del teléfono a actualizar
     * @return Objeto del teléfono actualizado
     */
    @Override
    @Transactional
    public Phone updateOnlyTelefono(Integer id, Phone telefono) {
        telefono.setId(id);
        telefono.setUpdatedAt(Instant.now());
        telefonoRepository.updateTelefono(id, telefono.getTelefono());
        return telefono;
    }

    /**
     * Borra un contacto del sistema
     *
     * @param id Identificación del contacto a borrar
     * @return Objeto del contacto borrado
     *
     */
    @Override
    @Transactional
    public Contact deleteContacto(Integer id) {
        var contacto = contactoRepository.findById(id);
        if (contacto.isPresent()) {
            contactoRepository.delete(contacto.get());
            return contacto.get();
        } else {
            return null;
        }
    }

    /**
     * Borra un teléfono del sistema
     * @param id Identificación del teléfono a borrar
     * @return Objeto del teléfono borrado
     */
    @Override
    @Transactional
    public Phone deleteTelefono(Integer id) {
        var telefono = telefonoRepository.findById(id);
        if (telefono.isPresent()) {
            telefonoRepository.delete(telefono.get());
            return telefono.get();
        } else {
            return null;
        }
    }
}
