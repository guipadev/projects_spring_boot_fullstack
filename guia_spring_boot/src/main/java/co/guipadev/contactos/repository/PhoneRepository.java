package co.guipadev.contactos.repository;

import co.guipadev.contactos.entity.Phone;
import co.guipadev.contactos.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PhoneRepository extends JpaRepository<Phone, Integer> {

    /**
     * Actualiza solamente el teléfono basado en el identificador de la tupla
     * @param id
     * @param telefono
     */
    @Modifying
    @Query(value = "update Telefono tel set tel.telefono = :telefono, tel.updatedAt = CURRENT_TIMESTAMP where tel.id = :id")
    public void updateTelefono(@Param(value = "id") Integer id, @Param(value = "telefono") String telefono);

    /**
     * Selecciona los teléfonos de un contacto en específico
     * @param contacto Objeto del contacto
     * @return Listado de teléfonos encontrados
     */
    @Query(value = "SELECT tel FROM Telefono tel WHERE tel.contacto = :contacto")
    public List<Phone> findAllByContacto(@Param(value = "contacto") Contact contacto);
}
