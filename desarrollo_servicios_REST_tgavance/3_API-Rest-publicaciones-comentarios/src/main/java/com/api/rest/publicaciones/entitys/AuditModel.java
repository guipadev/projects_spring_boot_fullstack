package com.api.rest.publicaciones.entitys;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Esta es una Super Clase para poder implementar
 * Esta admite entidades para mantener las propiedade básicas
 * No se asocia con ninguna tabla y BD
 * @MappedSuperclass para indicar que no es una clase entidad
 */
@MappedSuperclass
// Oyen actualizar la información de las fechas
@EntityListeners(AuditingEntityListener.class)
// No se serealice o transmita
@JsonIgnoreProperties(
        value = { "fecha_creacion", "fecha_actualizacion" }, allowGetters = true
)
@Getter
@Setter
public abstract class AuditModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha_creacion", nullable = false, updatable = false)
    @CreatedDate
    private Date fechaCreacion;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha_actualizacion", nullable = false)
    @LastModifiedDate
    private Date fechaActualizacion;


}
