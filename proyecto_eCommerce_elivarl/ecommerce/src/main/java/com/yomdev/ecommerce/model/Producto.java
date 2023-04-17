package com.yomdev.ecommerce.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "productos")
@Data
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    private String descripcion;

    private String imagen;

    private double precio;

    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
