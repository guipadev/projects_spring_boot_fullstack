package co.yom.crud.persistence.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import co.yom.crud.model.projection.AuthorProjection;
import co.yom.crud.persistence.entity.Author;

/**
 * Aveces nos toca realizar consultas propias del negocio
 * Como update o insertar registros en BD, pero registros propios sin usar el framework
 * Osea customizar nuestro metodos
 *
 * PagingAndSortingRepository realizar paginaciones
 * JpaSpecificationExecutor hacer consultas especiales query que se llaman especification o criteria pasamos lo que queremos de salida
 * puede ser la entidad pero no es recomendable, porque que tal tenga 100 campos, los trae tooos y solo necesitemos uno
 *
 * Para hacer projection toca realizar obligatoriamente la query
 * Esta debe ser una interfaz
 *
 * Al extender de dicho elemento spring sabe que esto es un repository y por eso no se le puso el @Repository
 */
public interface AuthorRepository extends PagingAndSortingRepository<Author, Integer>,JpaSpecificationExecutor<AuthorProjection>{

    /**
     * Aquí estamos haciendo personalizando un insert
     * medaiante @Modifying
     */
    @Modifying
    @Query("INSERT INTO Author (firstName,lastName,birthdate) VALUES "
            + "(:#{#author.firstName}, :#{#author.lastName}, :#{#author.birthdate})") // usar una clase dentro del query con el simbolo :#(#author que es el parametro definido
    Integer save(@Param("author") Author author); // Aquí se pasa una clase cuando hay mas de 2 campos

    @Modifying
    @Query("DELETE FROM Author a WHERE a.authorId = :authorId")
    void delete(@Param("authorId") Integer authorId);

    @Query("SELECT a.authorId as authorId, a.firstName as firstName, a.lastName as lastName, "
            + "a.firstName||' '||a.lastName as fullName, a.birthdate as birthdate "
            + "FROM Author a WHERE a.authorId = :authorId")
    AuthorProjection findByUserId(@Param("authorId") Integer authorId); // Interfaz Projection
    
    @Modifying
    @Query("UPDATE Author a SET a.firstName=:#{#author.firstName}, a.lastName=:#{#author.lastName}, a.birthdate=:#{#author.birthdate} "
            + "WHERE a.authorId = :#{#author.authorId}")
    Integer update(@Param("author") Author author);

}
