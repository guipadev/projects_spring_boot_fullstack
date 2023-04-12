package com.api.rest.party.entitys;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "fiestas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Fiesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fiesta_id")
    private Long id;

    private String ubicacion;

    @Column(name = "fiesta_fecha")
    @JsonFormat(pattern = "YYYY-MM-dd")
    private Date fecha;

    // A una fiesta puede asistir muchas personas
    @ManyToMany
    @JoinTable(name = "personas_fiestas", joinColumns = @JoinColumn(name = "fiesta_id", referencedColumnName = "fiesta_id"), inverseJoinColumns = @JoinColumn(name = "persona_id", referencedColumnName = "persona_id"))
    private Set<Persona> personas = new HashSet<>();
}
