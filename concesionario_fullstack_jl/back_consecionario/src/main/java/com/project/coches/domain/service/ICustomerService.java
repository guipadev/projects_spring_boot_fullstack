package com.project.coches.domain.service;

import com.project.coches.domain.dto.CustomerDto;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz de servicio cliente
 */
public interface ICustomerService {

    /**
     * Devuelve na lista con todos los clientes
     * @return Lista con clientes
     */
    List<CustomerDto> getAll();

    /**
     * Devuelve  un cliente dado su id
     * @param customerId Id de cliente
     * @return Optional del cliente encontrado
     */

    Optional<CustomerDto> getCustomerByCustomerId(String customerId);

    /**
     * Devuelve  un cliente dado su email
     * @param email de cliente
     * @return Optional del cliente encontrado
     */
    Optional<CustomerDto> getCustomerByEmail(String email);

    /**
     * Guarda/Actualizar un cliente
     * @param newCustomer cliente a guardar
     * @return cliente guardado
     */
    CustomerDto save(CustomerDto newCustomer);

    /**
     * Actualizar cliente
     * @param modifyCustomer cliente a modificar
     * @return actualizacion cliente
     */
    Optional<CustomerDto> update(CustomerDto modifyCustomer);

    /**
     * Elimina un clinete dado su id
     * @param customerId Id del cliente a eliminar
     */
    boolean delete(String customerId);
}
