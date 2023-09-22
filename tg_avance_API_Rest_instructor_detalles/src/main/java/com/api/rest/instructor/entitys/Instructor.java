package com.api.rest.instructor.entitys;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "instructor")
@Getter
@Setter
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String apellido;

    private String email;

    @OneToOne
    @JoinColumn(name = "instuctor_detalle_id")
    private InstructorDetalle instructorDetalle;
}
