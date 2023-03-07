package xyz.yadev.persona.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import java.io.Serializable;

@Data
@Entity
@Table(name = "estado")
@NoArgsConstructor
public class Estado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "pais_id")
    private Pais pais;
    private String nombre;

    public Estado(Pais pais, String nombre) {
        super();
        this.pais = pais;
        this.nombre = nombre;
    }
}
