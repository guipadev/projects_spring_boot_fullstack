package com.yomdev.ecommerce.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "detalles")
@Data
public class DetalleOrden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    private double cantidad;

    private double precio;

    private double total;

    @OneToOne
    private Orden orden;


    @ManyToOne
    @JoinColumn(name = "producto_id")
    private  Producto producto;
}
