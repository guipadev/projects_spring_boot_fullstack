package com.yomdev.ecommerce.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ordenes")
@Data
public class Orden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String numero;

    private Date fechaCreacion;

    private Date fechaRecibida;

    private double total;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "detalles_id")
    private List<DetalleOrden> detalle;
}
