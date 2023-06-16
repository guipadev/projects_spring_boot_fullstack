package com.api.rest.biblioteca.controllers;

import com.api.rest.biblioteca.entitys.Book;
import com.api.rest.biblioteca.entitys.Library;
import com.api.rest.biblioteca.services.BookService;
import com.api.rest.biblioteca.services.LibraryService;
import com.api.rest.biblioteca.services.impl.BookServiceImpl;
import com.api.rest.biblioteca.services.impl.LibraryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;
    private final LibraryService libraryService;

    @Autowired
    public BookController(BookServiceImpl bookService, LibraryServiceImpl libraryService) {
        this.bookService = bookService;
        this.libraryService = libraryService;
    }

    @GetMapping
    public ResponseEntity<Page<Book>> listBooks(Pageable pageable) {
        Page<Book> books = bookService.getAllBooks(pageable);
        return ResponseEntity.ok(books);
    }

    @PostMapping
    public ResponseEntity<Book> saveBook(@Valid @RequestBody Book book) {
        Optional<Library> libraryOptional = Optional.ofNullable(libraryService.getLibraryById(book.getLibrary().getId()));

        if (!libraryOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        book.setLibrary(libraryOptional.get());
        Book savedBook = bookService.saveBook(book);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedBook.getId()).toUri();

        return ResponseEntity.created(location).body(savedBook);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@Valid @RequestBody Book book, @PathVariable Long id) {
        Optional<Library> libraryOptional = Optional.ofNullable(libraryService.getLibraryById(book.getLibrary().getId()));

        if (!libraryOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        Optional<Book> bookOptional = Optional.ofNullable(bookService.getBookById(id));

        if (!bookOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        book.setLibrary(libraryOptional.get());
        book.setId(bookOptional.get().getId());

        bookService.saveBook(book);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable Long id) {
        Optional<Book> bookOptional = Optional.ofNullable(bookService.getBookById(id));

        if (!bookOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        bookService.deleteBook(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> searchBookById(@PathVariable Long id) {
        Optional<Book> bookOptional = Optional.ofNullable(bookService.getBookById(id));

        if (!bookOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        return ResponseEntity.ok(bookOptional.get());
    }
}
