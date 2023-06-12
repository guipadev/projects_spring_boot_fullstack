package yadev.persona.entitys.DTO;

import lombok.Data;
import yadev.persona.entitys.Estado;
import yadev.persona.entitys.Pais;

import java.io.Serializable;

@Data
public class PersonaDTO implements Serializable {

    private Long id;
    private String nombreCompleto;
    private String apellido;
    private int edad;
    private Pais pais;
    private Estado estado;
}
