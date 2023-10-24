package co.yom.crud.web.api;

import java.time.LocalDate;
import java.util.List;

import co.yom.crud.model.dto.AuthorParam;
import co.yom.crud.model.dto.RegisterAuthorDto;
import co.yom.crud.model.dto.UpdateAuthorDto;
import co.yom.crud.model.projection.AuthorProjection;
import co.yom.crud.persistence.repository.specification.AuthorSpecification;
import co.yom.crud.service.AuthorService;
import co.yom.crud.web.util.ResponseMessage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.SortDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.yom.crud.exception.ApiException;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorRest {

    private final AuthorService authorService;

    @PostMapping
    public ResponseEntity<Void> registerAuthor(@RequestBody RegisterAuthorDto registerAuthorDto) throws ApiException {
        authorService.saveAuthor(registerAuthorDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/pages")
    public ResponseEntity<Page<AuthorProjection>> findAllToPage(
            @RequestParam(name="q",defaultValue = "",required = false) String q, //q lo usamos como busqueda
            @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate birthdate, // buscar la fecha exacta, en este caso del autor
            @RequestParam(name = "page", defaultValue = "0", required = false) int page, // en que pagina esta
            @RequestParam(name = "size", defaultValue = "5", required = false) int size, // cuantas filas o resultado por pagina
            @SortDefault(sort = "authorId", direction = Direction.ASC) Sort sort) throws ApiException { // orden del resultado

        Pageable pageable = PageRequest.of(page, size, sort);

        // Tener control de la query
        AuthorSpecification authorSpecification = AuthorSpecification.builder()
                .q(q)
                .birthdate(birthdate)
                .build();
        
        Page<AuthorProjection> authors = authorService.findAllToPage(authorSpecification,pageable);

        return new ResponseEntity<>(authors, HttpStatus.OK);
    }
    
    @GetMapping("/{authorId}")
    public ResponseEntity<AuthorProjection> getAuthor(@PathVariable("authorId") Integer authorId) throws ApiException {
        AuthorProjection author = authorService.findAuthorId(authorId);
        
        return new ResponseEntity<>(author,HttpStatus.OK);
    }
    
    @GetMapping("/list")
    public ResponseEntity<List<AuthorProjection>> getAuthor(AuthorParam authorParam) throws ApiException {
        
    	AuthorSpecification authorSpecification = AuthorSpecification.builder()
                .q(authorParam.getQ())
                .birthdate(authorParam.getBirthdate())
                .build();
    	
    	List<AuthorProjection> authors = authorService.findAll(authorSpecification);
        
        return new ResponseEntity<>(authors,HttpStatus.OK);
    }
    
    
    @PutMapping("/{authorId}")
    public ResponseEntity<ResponseMessage<AuthorProjection>> updateAuthor(@PathVariable("authorId") Integer authorId, @RequestBody UpdateAuthorDto updateAuthorDto) throws ApiException {
        AuthorProjection authorProjection= authorService.updateAuthor(authorId, updateAuthorDto);
        
        ResponseMessage<AuthorProjection> msg = ResponseMessage.<AuthorProjection>builder()
                .message("Registro modificado")
                .content(authorProjection)
                .build();
        
        
        return new ResponseEntity<>(msg,HttpStatus.OK);
    }
    
    @DeleteMapping("/{authorId}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable("authorId") Integer authorId) throws ApiException {
        authorService.deleteAuthor(authorId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
