package co.yom.crud.persistence.repository;

import co.yom.crud.model.projection.BookProjection;
import co.yom.crud.persistence.dao.BookDao;
import co.yom.crud.persistence.entity.Book;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepository extends CrudRepository<Book, Integer>, PagingAndSortingRepository<Book, Integer>,JpaSpecificationExecutor<BookProjection>, BookDao {

    /*@Modifying
    @Query("INSERT INTO Book (title,publicationDate) VALUES (:#{#book.title}, :#{#book.publicationDate})")
    Integer save(@Param("book") Book book);

    

    @Modifying
    @Query("DELETE FROM Book b WHERE b.bookId = :bookId ")
    void delete(@Param("bookId") Integer bookId);*/
    //@Query("SELECT b.title, b.publicationDate FROM Book b WHERE b.bookId = :bookId")
    //Optional<BookProjection> findByBookId(@Param("bookId") Integer bookId);
}
