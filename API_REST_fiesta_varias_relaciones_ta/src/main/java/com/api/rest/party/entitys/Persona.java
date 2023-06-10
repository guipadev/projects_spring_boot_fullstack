package com.api.rest.party.entitys;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "personas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "persona_id")
    private Long id;

    private String nombre;

    private int edad;

    // Persona puede tener muchas habilidades, cascade para eliminar la persona como las habilidades en las 2 tablas
    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    private Set<Habilidad> habilidades = new HashSet<>();

    // Relacion muchos a muchos, la persona puede asisitr a muchas fiestas
    // Se creara una tabla intermedia y unas los ID de las personas y el ID de la persona referenciada
    @ManyToMany
    @JsonBackReference // Evitar problemas de recursividad para cuando retorne una persona no se quede en un retorno de lista infinita de fiestas asistidas // Tambien para que se pueda guardar y evitar la serializacion se omita, pero al traer los datos trabaje de forma normal
    @JoinTable(
            name = "personas_fiestas",  // Referencia las tablas por el ID
            joinColumns = @JoinColumn(name = "persona_id", referencedColumnName = "persona_id"),
            inverseJoinColumns = @JoinColumn(name = "fiesta_id", referencedColumnName = "fiesta_id")
    )
    private Set<Fiesta> fiestas = new HashSet<>();
}

