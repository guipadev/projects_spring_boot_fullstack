package co.yom.crud.model.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Muchas veces se declara un DTO, para hacer todo y esta mal
 * Por ejemplo aquí para registrar autores, solo se define los campos necesarios
 * nombre y apellido, aquí no hay ningun ID o algún otro campo
 * Siempre es bueno seccionarlo, por eso tenemos un DTO para actualizar autor UpdateAuthorDto
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class RegisterAuthorDto {
    
    private String firstName;
    private String lastName;

    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate birthdate;
}
