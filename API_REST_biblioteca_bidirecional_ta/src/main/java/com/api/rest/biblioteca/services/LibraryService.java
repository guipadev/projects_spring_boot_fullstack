package com.api.rest.biblioteca.services;

import com.api.rest.biblioteca.entitys.Library;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LibraryService {
    Page<Library> getAllLibraries(Pageable pageable);
    Library saveLibrary(Library library);
    Library editLibrary(Long id, Library library);
    void deleteLibrary(Long id);
    Library getLibraryById(Long id);
}
