package com.api.rest.biblioteca.entitys.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
public class LibraryDTO {

    private Long id;

    @NotNull
    private String name;

    /**
     * Excluido propiedad books utilizando @JsonProperty(access = JsonProperty.Access.WRITE_ONLY).
     * Esto se debe a que los DTO generalmente se utilizan para enviar datos desde el cliente al servidor,
     * y en este caso, solo necesitamos los bookIds para identificar los libros asociados a la biblioteca.
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<Long> bookIds;

}
