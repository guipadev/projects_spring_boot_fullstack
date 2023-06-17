package com.api.rest.biblioteca.services.impl;

import com.api.rest.biblioteca.entitys.Book;
import com.api.rest.biblioteca.entitys.Dto.BookDTO;
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
    public Page<BookDTO> getAllBooks(Pageable pageable) {
        Page<Book> books = bookRepository.findAll(pageable);
        return books.map(this::convertToDto);
    }

    @Override
    public BookDTO saveBook(BookDTO bookDTO) {
        Optional<Library> libraryOptional = libraryRepository.findById(bookDTO.getLibraryId());

        if (!libraryOptional.isPresent()) {
            throw new IllegalArgumentException("Invalid library ID.");
        }

        Book book = convertToEntity(bookDTO);
        book.setLibrary(libraryOptional.get());
        Book savedBook = bookRepository.save(book);
        return convertToDto(savedBook);
    }

    @Override
    public BookDTO updateBook(BookDTO bookDTO, Long id) {
        Optional<Library> libraryOptional = libraryRepository.findById(bookDTO.getLibraryId());

        if (!libraryOptional.isPresent()) {
            throw new IllegalArgumentException("Invalid library ID.");
        }

        Optional<Book> existingBookOptional = bookRepository.findById(id);

        if (!existingBookOptional.isPresent()) {
            throw new IllegalArgumentException("Invalid book ID.");
        }

        Book book = convertToEntity(bookDTO);
        book.setLibrary(libraryOptional.get());
        book.setId(existingBookOptional.get().getId());

        Book updatedBook = bookRepository.save(book);
        return convertToDto(updatedBook);
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
    public BookDTO getBookById(Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);

        if (!bookOptional.isPresent()) {
            throw new IllegalArgumentException("Invalid book ID.");
        }

        Book book = bookOptional.get();
        return convertToDto(book);
    }

    private BookDTO convertToDto(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setName(book.getName());
        bookDTO.setLibraryId(book.getLibrary().getId());
        return bookDTO;
    }

    private Book convertToEntity(BookDTO bookDTO) {
        Book book = new Book();
        book.setName(bookDTO.getName());
        return book;
    }
}
