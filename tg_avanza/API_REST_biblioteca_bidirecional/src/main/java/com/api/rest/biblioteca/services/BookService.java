package com.api.rest.biblioteca.services;

import com.api.rest.biblioteca.entitys.Dto.BookDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    Page<BookDTO> getAllBooks(Pageable pageable);
    BookDTO saveBook(BookDTO bookDTO);
    BookDTO updateBook(BookDTO bookDTO, Long id);
    void deleteBook(Long id);
    BookDTO getBookById(Long id);
}
