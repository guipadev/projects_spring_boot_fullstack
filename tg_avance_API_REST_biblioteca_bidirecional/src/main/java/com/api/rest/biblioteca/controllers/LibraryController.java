package com.api.rest.biblioteca.controllers;

import com.api.rest.biblioteca.entitys.Dto.LibraryDTO;
import com.api.rest.biblioteca.services.impl.LibraryServiceImpl;
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

    private final LibraryServiceImpl libraryService;

    @Autowired
    public LibraryController(LibraryServiceImpl libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping
    public ResponseEntity<Page<LibraryDTO>> listAllLibraries(Pageable pageable) {
        Page<LibraryDTO> libraries = libraryService.getAllLibraries(pageable);
        return ResponseEntity.ok(libraries);
    }

    @PostMapping
    public ResponseEntity<LibraryDTO> saveLibrary(@Valid @RequestBody LibraryDTO libraryDTO) {
        LibraryDTO savedLibrary = libraryService.saveLibrary(libraryDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedLibrary.getId()).toUri();

        return ResponseEntity.created(location).body(savedLibrary);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LibraryDTO> editLibrary(@PathVariable Long id, @Valid @RequestBody LibraryDTO libraryDTO) {
        LibraryDTO editedLibrary = libraryService.editLibrary(id, libraryDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibrary(@PathVariable Long id) {
        libraryService.deleteLibrary(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibraryDTO> getLibraryById(@PathVariable Long id) {
        LibraryDTO libraryDTO = libraryService.getLibraryById(id);
        return ResponseEntity.ok(libraryDTO);
    }
}
