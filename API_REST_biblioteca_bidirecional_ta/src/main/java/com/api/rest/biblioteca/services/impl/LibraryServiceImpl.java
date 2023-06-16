package com.api.rest.biblioteca.services.impl;

import com.api.rest.biblioteca.entitys.Library;
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
    public Page<Library> getAllLibraries(Pageable pageable) {
        return libraryRepository.findAll(pageable);
    }

    @Override
    public Library saveLibrary(Library library) {
        return libraryRepository.save(library);
    }

    @Override
    public Library editLibrary(Long id, Library library) {
        Optional<Library> libraryOptional = libraryRepository.findById(id);

        if (!libraryOptional.isPresent()) {
            throw new IllegalArgumentException("Invalid library ID.");
        }

        library.setId(libraryOptional.get().getId());
        return libraryRepository.save(library);
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
    public Library getLibraryById(Long id) {
        Optional<Library> libraryOptional = libraryRepository.findById(id);

        if (!libraryOptional.isPresent()) {
            throw new IllegalArgumentException("Invalid library ID.");
        }

        return libraryOptional.get();
    }
}