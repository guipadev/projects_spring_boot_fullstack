package co.yom.crud.persistence.entity;

import java.io.Serializable;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "book_authors")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class BookAuthor implements Serializable{

    private static final long serialVersionUID = -6636165613629960798L;

    // Indica que el ID esta conformado por dos ID, que se ven en los ManyToOne de BookAuthorId
    @EmbeddedId
    private BookAuthorId bookAuthorId;
    
    
}
