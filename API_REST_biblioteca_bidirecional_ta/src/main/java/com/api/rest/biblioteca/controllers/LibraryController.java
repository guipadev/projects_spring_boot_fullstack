package com.api.rest.biblioteca.controllers;

import com.api.rest.biblioteca.entitys.Library;
import com.api.rest.biblioteca.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/library")
public class LibraryController {

    private final LibraryService libraryService;

    @Autowired
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping
    public ResponseEntity<Page<Library>> listAllLibraries(Pageable pageable) {
        Page<Library> libraries = libraryService.getAllLibraries(pageable);
        return ResponseEntity.ok(libraries);
    }

    @PostMapping
    public ResponseEntity<Library> saveLibrary(@Valid @RequestBody Library library) {
        Library savedLibrary = libraryService.saveLibrary(library);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedLibrary.getId()).toUri();

        return ResponseEntity.created(location).body(savedLibrary);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Library> editLibrary(@PathVariable Long id, @Valid @RequestBody Library library) {
        Library editedLibrary = libraryService.editLibrary(id, library);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Library> deleteLibrary(@PathVariable Long id) {
        libraryService.deleteLibrary(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Library> getLibraryById(@PathVariable Long id) {
        Library library = libraryService.getLibraryById(id);
        return ResponseEntity.ok(library);
    }
}
