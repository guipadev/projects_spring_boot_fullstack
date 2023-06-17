package com.api.rest.biblioteca.controllers;

import com.api.rest.biblioteca.entitys.Dto.BookDTO;
import com.api.rest.biblioteca.services.impl.BookServiceImpl;
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

    private final BookServiceImpl bookService;

    @Autowired
    public BookController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<Page<BookDTO>> listBooks(Pageable pageable) {
        Page<BookDTO> books = bookService.getAllBooks(pageable);
        return ResponseEntity.ok(books);
    }

    @PostMapping
    public ResponseEntity<BookDTO> saveBook(@Valid @RequestBody BookDTO bookDTO) {
        BookDTO savedBook = bookService.saveBook(bookDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedBook.getId()).toUri();

        return ResponseEntity.created(location).body(savedBook);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateBook(@Valid @RequestBody BookDTO bookDTO, @PathVariable Long id) {
        BookDTO updatedBook = bookService.updateBook(bookDTO, id);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> searchBookById(@PathVariable Long id) {
        Optional<BookDTO> bookOptional = Optional.ofNullable(bookService.getBookById(id));

        if (!bookOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(bookOptional.get());
    }
}
