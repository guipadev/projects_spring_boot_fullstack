package com.yomdev.app.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private Integer id;

    private String nombre;

    private  String email;

    private String password;
}
