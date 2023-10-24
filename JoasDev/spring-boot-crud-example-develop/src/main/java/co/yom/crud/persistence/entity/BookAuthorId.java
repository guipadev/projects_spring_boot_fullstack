package co.yom.crud.persistence.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Al ser una tabla de muchos a muchos no tiene ID
 */
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class BookAuthorId implements Serializable {

    private static final long serialVersionUID = -6303028027418297529L;

    /**
     * Los ID de atributos siempre son diferentes únicos
     */
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book bookId;
    
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author authorId;
    
}
