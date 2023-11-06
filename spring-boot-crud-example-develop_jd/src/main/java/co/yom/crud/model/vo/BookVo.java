package co.yom.crud.model.vo;

import java.time.LocalDate;

import co.yom.crud.model.projection.BookProjection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * VO View Object, son salidas de los repositorios, el resultado que me da al consumir un repositorio
 * Pero, se manejan en temas de inmutabilidad, ya que nada se va a cambiar dentro de esta clase
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@ToString
public class BookVo implements BookProjection {
    private Integer bookId;
    private String title;
    private LocalDate publicationDate;
    private String concatAuthors;
    private Boolean onlineAvailability;
    
    @Override
    public Integer getBookId() {
        return bookId;
    }
    @Override
    public Boolean getOnlineAvailability() {
        return onlineAvailability;
    }
    @Override
    public String getConcatAuthors() {
        return concatAuthors;
    }
    @Override
    public String getTitle() {
        return title;
    }
    @Override
    public LocalDate getPublicationDate() {
        return publicationDate;
    }

}
