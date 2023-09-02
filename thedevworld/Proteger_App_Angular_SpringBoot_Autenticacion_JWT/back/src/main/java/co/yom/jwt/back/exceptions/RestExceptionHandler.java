package co.yom.jwt.back.exceptions;


import co.yom.jwt.back.dtos.ErrorDto;
import co.yom.jwt.back.exceptions.AppException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Advice Configuration
 */
@ControllerAdvice
public class RestExceptionHandler {

    // Mapeo este método solo a la excepción de la aplicación
    // Y devuelvo un cuerpo de Json
    @ExceptionHandler(value = { AppException.class })
    @ResponseBody
    public ResponseEntity<ErrorDto> handleException(AppException ex) {
        // Devuelvo directamente una entidad de respuesta con el estado y cuerpo dado
        return ResponseEntity
                .status(ex.getStatus())
                .body(new ErrorDto(ex.getMessage())); // Se crea el error del DTO
    }
}