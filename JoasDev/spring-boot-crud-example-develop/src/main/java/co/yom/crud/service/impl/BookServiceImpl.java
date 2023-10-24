package co.yom.crud.service.impl;

import co.yom.crud.model.projection.BookProjection;
import co.yom.crud.persistence.entity.BookAuthorId;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.yom.crud.exception.ApiException;
import co.yom.crud.model.dto.RegisterBookDto;
import co.yom.crud.persistence.entity.Author;
import co.yom.crud.persistence.entity.Book;
import co.yom.crud.persistence.entity.BookAuthor;
import co.yom.crud.persistence.repository.BookAuthorRepository;
import co.yom.crud.persistence.repository.BookRepository;
import co.yom.crud.persistence.repository.specification.BookSpecification;
import co.yom.crud.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;    
    private final BookAuthorRepository bookAuthorRepository;    
    private final ModelMapper modelMapper;
    
    @Override
    @Transactional
    public Integer saveBook(RegisterBookDto registerBookDto) throws ApiException {
        Book bookEntity;
        
        Book bookSave = null;
        try {
            
            bookEntity = modelMapper.map(registerBookDto, Book.class);
            bookSave = bookRepository.save(bookEntity);
            Integer resultBookId = bookSave.getBookId();
            registerBookDto.getAuthors().stream().forEach( authorId -> {
                
                Author author = Author.builder()
                        .authorId(authorId)
                        .build();
                
                Book bookId = Book.builder()
                        .bookId(resultBookId)
                        .build();
                
                BookAuthorId bookAuthorId = BookAuthorId.builder()
                        .bookId(bookId)
                        .authorId(author)
                        .build();
                
                BookAuthor bookAuthorEntity = BookAuthor.builder()
                        .bookAuthorId(bookAuthorId)
                        .build();
                
                bookAuthorRepository.save(bookAuthorEntity);
                
                
            });
        }catch (Exception e) {
            log.error(e.getMessage());
            throw new ApiException("Error in Detail", HttpStatus.NOT_FOUND);
        }
        
        return bookSave.getBookId();
    }

    @Override
    public Page<BookProjection> findAllToPage(BookSpecification bookSpec, Pageable pageable) throws ApiException {
       
        return bookRepository.findAllToPage(bookSpec, pageable);
    }

    @Override
    public BookProjection findBookId(Integer bookId) throws ApiException {
        
        BookProjection bookProjection=null;
        try {
            bookProjection = bookAuthorRepository.findByBookId(bookId);
           log.info("bookId: "+bookProjection.getBookId());
        }catch (Exception e) {
            log.error(e.getMessage());
            throw new ApiException("Error in query", HttpStatus.NOT_FOUND);
        }
        
        /*if(bookProjection.isEmpty()) {
            throw new ApiException("Error exist bookId: "+bookId, HttpStatus.NOT_FOUND);
        }*/
        
        return bookProjection;
    }

    @Override
    @Transactional
    public void deleteBook(Integer bookId) throws ApiException {
        
        try {
            
            bookAuthorRepository.deleteByBookId(bookId);
            
            
            Book bookEntity = Book.builder()
                    .bookId(bookId)
                    .build();
            /*
            Boolean exist = bookAuthorRepository.existByBookId(bookId);
            if(exist!=null && exist) {
            	bookAuthorRepository.deleteByBookId(bookId);
            }*/
            
            bookRepository.delete(bookEntity);
        }catch (Exception e) {
            log.error(e.getMessage());
            throw new ApiException("Not delete book", HttpStatus.NOT_FOUND);
        }
        
    }

   
    
}
