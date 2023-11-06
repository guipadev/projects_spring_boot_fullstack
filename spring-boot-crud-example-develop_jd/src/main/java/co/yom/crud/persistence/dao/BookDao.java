package co.yom.crud.persistence.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import co.yom.crud.exception.ApiException;
import co.yom.crud.model.projection.BookProjection;
import co.yom.crud.persistence.repository.specification.BookSpecification;

/**
 * Este DAO es opcional, porque a veces lo manejamos todo con repositorio
 * Pero aquí se hace un hibrido, porque tambien hay en este paquete un repositorio
 */
public interface BookDao {

    Page<BookProjection> findAllToPage(BookSpecification bookSpec, Pageable pageable) throws ApiException;
    
}
