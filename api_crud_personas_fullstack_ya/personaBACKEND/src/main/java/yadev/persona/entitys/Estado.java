package yadev.persona.entitys;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

    @Column(name = "estadonombre")
    private String nombre;

    public Estado(Pais pais, String nombre) {
        super();
        this.pais = pais;
        this.nombre = nombre;
    }
}
