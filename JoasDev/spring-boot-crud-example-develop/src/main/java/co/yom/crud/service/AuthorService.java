package co.yom.crud.service;

import java.util.List;

import co.yom.crud.persistence.repository.specification.AuthorSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import co.yom.crud.exception.ApiException;
import co.yom.crud.model.dto.RegisterAuthorDto;
import co.yom.crud.model.dto.UpdateAuthorDto;
import co.yom.crud.model.projection.AuthorProjection;

public interface AuthorService {

    Integer saveAuthor(RegisterAuthorDto registerAuthorDto) throws ApiException;

    Page<AuthorProjection> findAllToPage(AuthorSpecification authorSpecification, Pageable pageable) throws ApiException;
    
    AuthorProjection updateAuthor(Integer authorId,UpdateAuthorDto updateAuthorDto) throws ApiException;
    
    void deleteAuthor(Integer authorId) throws ApiException;

    AuthorProjection findAuthorId(Integer authorId) throws ApiException;

	List<AuthorProjection> findAll(AuthorSpecification authorSpecification);
}
