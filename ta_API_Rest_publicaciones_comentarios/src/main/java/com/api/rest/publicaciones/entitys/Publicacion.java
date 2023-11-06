package com.api.rest.publicaciones.entitys;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "publicaciones")
@Getter
@Setter
public class Publicacion extends AuditModel{

    private  static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 100)
    @Column(unique = true)
    private String titulo;

    @NotNull
    @Size(max = 250)
    @Lob // Tener datos largos
    private String descripcion;

    @NotNull
    @Lob
    private String contenido;
}
