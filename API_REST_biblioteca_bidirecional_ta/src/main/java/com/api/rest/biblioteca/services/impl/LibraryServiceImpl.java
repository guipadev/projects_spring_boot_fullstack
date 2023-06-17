package com.api.rest.biblioteca.services.impl;

import com.api.rest.biblioteca.entitys.Library;
import com.api.rest.biblioteca.entitys.Dto.LibraryDTO;
import com.api.rest.biblioteca.repositorys.LibraryRepository;
import com.api.rest.biblioteca.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LibraryServiceImpl implements LibraryService {

    private final LibraryRepository libraryRepository;

    @Autowired
    public LibraryServiceImpl(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    @Override
    public Page<LibraryDTO> getAllLibraries(Pageable pageable) {
        Page<Library> libraries = libraryRepository.findAll(pageable);
        return libraries.map(this::convertToDTO);
    }

    @Override
    public LibraryDTO saveLibrary(LibraryDTO libraryDTO) {
        Library library = convertToEntity(libraryDTO);
        Library savedLibrary = libraryRepository.save(library);
        return convertToDTO(savedLibrary);
    }

    @Override
    public LibraryDTO editLibrary(Long id, LibraryDTO libraryDTO) {
        Optional<Library> libraryOptional = libraryRepository.findById(id);

        if (!libraryOptional.isPresent()) {
            throw new IllegalArgumentException("Invalid library ID.");
        }

        Library library = libraryOptional.get();
        library.setName(libraryDTO.getName());

        Library updatedLibrary = libraryRepository.save(library);
        return convertToDTO(updatedLibrary);
    }

    @Override
    public void deleteLibrary(Long id) {
        Optional<Library> libraryOptional = libraryRepository.findById(id);

        if (!libraryOptional.isPresent()) {
            throw new IllegalArgumentException("Invalid library ID.");
        }

        libraryRepository.delete(libraryOptional.get());
    }

    @Override
    public LibraryDTO getLibraryById(Long id) {
        Optional<Library> libraryOptional = libraryRepository.findById(id);

        if (!libraryOptional.isPresent()) {
            throw new IllegalArgumentException("Invalid library ID.");
        }

        Library library = libraryOptional.get();
        return convertToDTO(library);
    }

    private LibraryDTO convertToDTO(Library library) {
        LibraryDTO libraryDTO = new LibraryDTO();
        libraryDTO.setId(library.getId());
        libraryDTO.setName(library.getName());
        return libraryDTO;
    }

    private Library convertToEntity(LibraryDTO libraryDTO) {
        Library library = new Library();
        library.setName(libraryDTO.getName());
        return library;
    }
}
