package co.yom.crud.web.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Generico creado donde pasamos algo y devuelve un mensaje de cualquier tipo
 * tenemos que declara el tipo
 * @param <T>
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ResponseMessage<T> {

    /**
     * Aquí lo único a mostrar es un mensaje, podriamos poner el codigo error referente a la empresa...
     * Porque hay muchos tipos de errores y podemos crear los propios tipos, dependiendo empresa o como este estructurado
     * Ej. podemos usar 800 que no tiene nada que ver con los status, indicamos 801 falta caracter para tipo X
     */
    private String message;
    
    @JsonInclude(Include.NON_NULL)
    private T content;
    
}
