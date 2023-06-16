package com.api.rest.biblioteca.services;

import com.api.rest.biblioteca.entitys.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {

    Page<Book> getAllBooks(Pageable pageable);
    Book saveBook(Book book);
    Book updateBook(Book book, Long id);
    void deleteBook(Long id);
    Book getBookById(Long id);
}
