package yadev.persona.entitys.DTO;

import lombok.Data;

import java.io.Serializable;

@Data
public class PaisDTO implements Serializable {
    private Long id;
    private String nombre;
}
