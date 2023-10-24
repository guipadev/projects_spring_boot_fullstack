package co.yom.crud.service.impl;

import java.util.List;

import co.yom.crud.persistence.repository.specification.AuthorSpecification;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.yom.crud.exception.ApiException;
import co.yom.crud.model.dto.RegisterAuthorDto;
import co.yom.crud.model.dto.UpdateAuthorDto;
import co.yom.crud.model.projection.AuthorProjection;
import co.yom.crud.persistence.entity.Author;
import co.yom.crud.persistence.repository.AuthorRepository;
import co.yom.crud.persistence.repository.BookAuthorRepository;
import co.yom.crud.service.AuthorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService{
	
    private final AuthorRepository authorRepository;
    private final BookAuthorRepository bookAuthorRepository;
    private final ModelMapper modelMapper;
    
    @Override
    /**
     * Cuando se ingresa mucha data, por ejemplo si tienes un método que tiene un ciclo for de ingresar información
     * Y en un momento falla, hacer un rollback y si has ido ingresando data te lo elimina los registros
     * Y si todo sale bien pushea esos datos. Todo tema transacccional como registro o actualización,
     */
    @Transactional
    public Integer saveAuthor(RegisterAuthorDto registerAuthorDto) throws ApiException {

        Author authorEntity = null;
        Integer authorResult = null;        
        try {
            // Convertir el DTO a un Entity, trayendo las cosas iguales del dto a la entidad
            // en este caso el ID queda en Nulo porque no esta mapeado en el DTO
            authorEntity = modelMapper.map(registerAuthorDto, Author.class);
            // Al momento de registrar una entidad que no tiene ID, en JPA lo registra
            authorResult = authorRepository.save(authorEntity);
        }catch(Exception e) {
            log.error(e.getMessage());
            throw new ApiException("Error al insetar datos", HttpStatus.NOT_FOUND);
        }
                
        return authorResult;
    }

    @Override
    public Page<AuthorProjection> findAllToPage(AuthorSpecification authorSpecification, Pageable pageable) throws ApiException {
        
        Page<AuthorProjection> result = null;
        
        try {
            result = authorRepository.findAll(authorSpecification, pageable);
        }catch (Exception e) {
            log.error(e.getMessage());
            throw new ApiException("Empty", HttpStatus.NOT_FOUND);
        }
        
        return result;
    }

    @Override
    @Transactional
    public void deleteAuthor(Integer authorId) throws ApiException {

        try {
        	
        	Boolean exist = bookAuthorRepository.existByAuthorId(authorId);
        	
        	if(exist!=null && exist) {
        		bookAuthorRepository.deleteByAuthorId(authorId);
        	}
        	
            authorRepository.delete(authorId);
        }catch (Exception e) {
            log.error(e.getMessage());
            throw new ApiException("Empty", HttpStatus.NOT_FOUND);
        }        
    }

    @Override
    public AuthorProjection findAuthorId(Integer authorId) throws ApiException {

        AuthorProjection authorProjection = null;
        
        try {
            authorProjection = authorRepository.findByUserId(authorId);
        }catch (Exception e) {
            log.error(e.getMessage());
            throw new ApiException("Empty", HttpStatus.NOT_FOUND);
        }

        if(authorProjection==null) {
            throw new ApiException("Not exist author "+authorId, HttpStatus.NOT_FOUND);
        }
        
        return authorProjection;
    }

    @Override
    @Transactional
    public AuthorProjection updateAuthor(Integer authorId,UpdateAuthorDto updateAuthorDto) throws ApiException {

        Author authorEntity = null;
        Integer resultId = null;        
        try {
            authorEntity = modelMapper.map(updateAuthorDto, Author.class);
            authorEntity.setAuthorId(authorId);
            resultId = authorRepository.update(authorEntity);
        }catch(Exception e) {
            log.error(e.getMessage());
            throw new ApiException("Error in Update "+authorId, HttpStatus.NOT_FOUND);
        }
        
        if(resultId==0) {
        	throw new ApiException("Not exist authorId: "+authorId, HttpStatus.NOT_FOUND);
        }
             
        return authorRepository.findByUserId(resultId);
        
    }

	@Override
	public List<AuthorProjection> findAll(AuthorSpecification authorSpecification) {
		return authorRepository.findAll(authorSpecification);
	}

    
    
}
