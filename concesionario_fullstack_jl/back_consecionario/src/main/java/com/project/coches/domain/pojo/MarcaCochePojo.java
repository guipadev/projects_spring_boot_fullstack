package com.project.coches.domain.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;

/**
 * Pojo de marca Coche
 */
@Getter @Setter
public class MarcaCochePojo {

    /**
     * Id de la marca
     */
    private  Integer id;

    /**
     * Descripción de la marca
     */
    private String description;
}
