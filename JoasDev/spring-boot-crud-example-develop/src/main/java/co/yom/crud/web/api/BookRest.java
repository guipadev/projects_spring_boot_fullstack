package co.yom.crud.web.api;

import java.time.LocalDate;

import co.yom.crud.model.dto.RegisterBookDto;
import co.yom.crud.model.projection.BookProjection;
import co.yom.crud.persistence.repository.specification.BookSpecification;
import co.yom.crud.service.BookService;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.yom.crud.exception.ApiException;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookRest {
    
    private final BookService bookService;

    @PostMapping
    public ResponseEntity<Void> registerAuthor(@RequestBody RegisterBookDto registerBookDto) throws ApiException {
        bookService.saveBook(registerBookDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/pages")
    public ResponseEntity<Page<BookProjection>> findAllToPage(
            @RequestParam(name="q",defaultValue = "",required = false) String q,
            @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate publicationDate,
            @RequestParam(name = "page", defaultValue = "0", required = false) int page,
            @RequestParam(name = "size", defaultValue = "5", required = false) int size,
            @SortDefault(sort = "bookId", direction = Direction.ASC) Sort sort) throws ApiException {

        Pageable pageable = PageRequest.of(page, size, sort);

        BookSpecification bookSpec = BookSpecification.builder()
                .q(q)
                .publicationDate(publicationDate)
                .build();
        
        Page<BookProjection> books = bookService.findAllToPage(bookSpec,pageable);

        return new ResponseEntity<>(books, HttpStatus.OK);
    }
    
    @GetMapping("/{bookId}")
    public ResponseEntity<BookProjection> getAuthor(@PathVariable("bookId") Integer bookId) throws ApiException {
        BookProjection author = bookService.findBookId(bookId);
        
        return new ResponseEntity<>(author, HttpStatus.OK);
    }
    
    @DeleteMapping("/{bookId}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable("bookId") Integer bookId) throws ApiException {
        bookService.deleteBook(bookId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
