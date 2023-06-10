package xyz.yadev.persona.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@Table(name = "persona")
@NoArgsConstructor
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "nombre_completo") // En BD tendra este nombre
    private String nombre;
    private String apellido;
    private int edad;

    // Una persona solo se puede asociar un país, pero un país se asociaran muchas personas
    @ManyToOne
    @JoinColumn(name = "pais_id")
    private Pais pais;
    @ManyToOne
    @JoinColumn(name = "estado_id")
    private Estado estado;

    public Persona(String nombre, String apellido, int edad, Pais pais, Estado estado) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.pais = pais;
        this.estado = estado;
    }
}
