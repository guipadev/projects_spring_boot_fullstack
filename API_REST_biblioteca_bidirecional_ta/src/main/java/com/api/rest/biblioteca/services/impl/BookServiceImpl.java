package com.api.rest.biblioteca.services.impl;

import com.api.rest.biblioteca.entitys.Book;
import com.api.rest.biblioteca.entitys.Library;
import com.api.rest.biblioteca.repositorys.BookRepository;
import com.api.rest.biblioteca.repositorys.LibraryRepository;
import com.api.rest.biblioteca.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final LibraryRepository libraryRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, LibraryRepository libraryRepository) {
        this.bookRepository = bookRepository;
        this.libraryRepository = libraryRepository;
    }

    @Override
    public Page<Book> getAllBooks(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public Book saveBook(Book book) {
        Optional<Library> libraryOptional = libraryRepository.findById(book.getLibrary().getId());

        if (!libraryOptional.isPresent()) {
            throw new IllegalArgumentException("Invalid library ID.");
        }

        book.setLibrary(libraryOptional.get());
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Book book, Long id) {
        Optional<Library> libraryOptional = libraryRepository.findById(book.getLibrary().getId());

        if (!libraryOptional.isPresent()) {
            throw new IllegalArgumentException("Invalid library ID.");
        }

        Optional<Book> existingBookOptional = bookRepository.findById(id);

        if (!existingBookOptional.isPresent()) {
            throw new IllegalArgumentException("Invalid book ID.");
        }

        book.setLibrary(libraryOptional.get());
        book.setId(existingBookOptional.get().getId());

        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);

        if (!bookOptional.isPresent()) {
            throw new IllegalArgumentException("Invalid book ID.");
        }

        bookRepository.delete(bookOptional.get());
    }

    @Override
    public Book getBookById(Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);

        if (!bookOptional.isPresent()) {
            throw new IllegalArgumentException("Invalid book ID.");
        }

        return bookOptional.get();
    }
}