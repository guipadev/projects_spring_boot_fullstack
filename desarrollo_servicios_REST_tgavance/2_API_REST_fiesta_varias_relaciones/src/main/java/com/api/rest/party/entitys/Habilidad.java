package com.api.rest.party.entitys;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "habilidades")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Habilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "habilidad_id")
    private Long id;

    private String nombre;

    @Enumerated(EnumType.STRING)
    private Nivel nivel;

    // Muchas habilidades puede tener una persona
    @ManyToOne
    @JoinColumn(name = "persona_id")
    @JsonBackReference
    private Persona persona;
}
