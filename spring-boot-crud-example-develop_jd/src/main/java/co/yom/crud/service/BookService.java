package co.yom.crud.service;

import co.yom.crud.model.dto.RegisterBookDto;
import co.yom.crud.model.projection.BookProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import co.yom.crud.exception.ApiException;
import co.yom.crud.persistence.repository.specification.BookSpecification;

public interface BookService {

    Integer saveBook(RegisterBookDto registerBookDto) throws ApiException;

    Page<BookProjection> findAllToPage(BookSpecification bookSpec, Pageable pageable) throws ApiException;

    BookProjection findBookId(Integer bookId) throws ApiException;
    
    void deleteBook(Integer bookId) throws ApiException;

}
