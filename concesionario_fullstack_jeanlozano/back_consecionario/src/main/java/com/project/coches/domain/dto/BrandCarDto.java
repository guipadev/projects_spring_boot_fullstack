package com.project.coches.domain.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Pojo de marca Coche
 */
@Getter @Setter
public class BrandCarDto {

    /**
     * Id de la marca
     */
    private  Integer id;

    /**
     * Descripción de la marca
     */
    private String description;
}
