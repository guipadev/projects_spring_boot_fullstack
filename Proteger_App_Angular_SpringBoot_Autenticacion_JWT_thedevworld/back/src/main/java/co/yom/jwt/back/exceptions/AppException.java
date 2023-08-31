package co.yom.jwt.back.exceptions;

import org.springframework.http.HttpStatus;

/**
 * Queremos que la aplicación intercepte esta excepción personalizada
 * Y devuelva el mensaje dado y el código HTTP
 */
public class AppException extends RuntimeException {

    private final HttpStatus httpStatus;

    public AppException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getStatus() {
        return httpStatus;
    }
}
