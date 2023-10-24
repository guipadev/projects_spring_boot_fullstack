package co.yom.crud.model.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Aunque tenga los mismo campos que RegistreAuthorDto
 * Esta sección es para solo actualizar datos necearios del autor
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class UpdateAuthorDto {
    
    private String firstName;
    private String lastName;

    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate birthdate;
}
