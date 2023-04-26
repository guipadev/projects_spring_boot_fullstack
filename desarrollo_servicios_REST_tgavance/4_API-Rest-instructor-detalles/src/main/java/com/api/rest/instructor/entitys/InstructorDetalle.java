package com.api.rest.instructor.entitys;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "instructor_detalle")
public class InstructorDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "canal_youtube")
    private String canalYoutube;

    @Column(name = "pasa_tiempo")
    private String pasaTiempo;
}
