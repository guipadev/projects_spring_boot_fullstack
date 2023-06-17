package com.api.rest.biblioteca.services;

import com.api.rest.biblioteca.entitys.Dto.LibraryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LibraryService {
    Page<LibraryDTO> getAllLibraries(Pageable pageable);
    LibraryDTO saveLibrary(LibraryDTO libraryDTO);
    LibraryDTO editLibrary(Long id, LibraryDTO libraryDTO);
    void deleteLibrary(Long id);
    LibraryDTO getLibraryById(Long id);
}
