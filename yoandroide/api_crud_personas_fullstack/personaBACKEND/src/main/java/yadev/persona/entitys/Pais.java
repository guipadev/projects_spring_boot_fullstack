package yadev.persona.entitys;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "pais")
@NoArgsConstructor
public class Pais implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "paisnombre")
    private String nombre;

    public Pais(String nombre) {
        super();
        this.nombre = nombre;
    }
}
