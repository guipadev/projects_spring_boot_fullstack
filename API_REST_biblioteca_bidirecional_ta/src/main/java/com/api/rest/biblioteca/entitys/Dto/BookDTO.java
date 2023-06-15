package com.api.rest.biblioteca.entitys.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class BookDTO {

    private Long id;

    @NotNull
    private String name;

    /**
     * Se excluye propiedad library utilizando @JsonProperty(access = JsonProperty.Access.WRITE_ONLY).
     * Esto se debe a que los DTO generalmente se utilizan para enviar datos desde el cliente al servidor,
     * y en este caso, solo necesitamos el libraryId para identificar la biblioteca a la que pertenece el libro.
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long libraryId;
}