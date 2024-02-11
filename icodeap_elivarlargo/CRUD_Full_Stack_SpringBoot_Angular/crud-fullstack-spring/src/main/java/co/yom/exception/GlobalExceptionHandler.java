package co.yom.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * Clase interceptor entre las solicitudes realizadas por cliente el back
 * Todas las peticiónes o exepciones que ocurran en una petición pasaran por
 * esta clase
 * Permite capturar todas las excepciones a nivel global
 * Podemos personalizar cualquier tipo de excepción, como validar que un
 * registro no se ingrese dos veces...
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    // Método con clase personalizada e indicando clase personalizada de la clase
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(
            ResourceNotFoundException ex, // Captura todas las exepciones de este tipo
            WebRequest webRequest) {

        ErrorDetails error = new ErrorDetails(
                LocalDateTime.now(),
                ex.getMessage(),
                webRequest.getDescription(false),
                "NOT FOUND");

        // Devuelve clase error y codigo que deseemos en este caso que no encuentra dato
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
