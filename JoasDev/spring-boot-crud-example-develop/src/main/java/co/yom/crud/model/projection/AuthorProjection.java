package co.yom.crud.model.projection;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Es una interface donde se declaran los métodos que se desean registrar
 * define los getters y setters
 * osea todo esto es lo que saldra en pantalla
 * Aqui se define las columnas que deseo se visualicen de la tabla segun la query
 */
public interface AuthorProjection {
    Integer getAuthorId();
    String getFirstName();
    String getLastName();
    String getFullName();
    
    @JsonFormat(pattern="dd-MM-yyyy")
    LocalDate getBirthdate();    
}
