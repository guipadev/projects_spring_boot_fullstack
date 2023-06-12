package yadev.persona.entitys.DTO;

import lombok.Data;
import yadev.persona.entitys.Pais;

import java.io.Serializable;

@Data
public class EstadoDTO implements Serializable {

    private Long id;
    private Pais pais;
    private String nombre;

}
