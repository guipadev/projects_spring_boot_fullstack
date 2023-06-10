package com.api.rest.publicaciones.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "comentarios")
@Getter
@Setter
public class Comentario extends AuditModel {

    private static final long serialVersionUID =  1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Lob // Tener datos largos
    private String texto;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "publicacion_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE) // Elimina todos los datos de las relaciones
    @JsonIgnore // Se posible a la hora de deserializar y no serializar
    private Publicacion publicacion;
}
