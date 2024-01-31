package co.yom.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Plantilla para devolver la información al cliente de los errores que suceden
 * Clase donde devolvemos información especifica para una excepción
 * como es ResourceNotFoundException
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ErrorDetails {

    private LocalDateTime timeStamp;
    private String message;
    private String path;
    private String errorCode;

}
