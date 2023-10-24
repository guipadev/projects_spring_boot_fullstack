package co.yom.crud.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

/**
 * Tener control de las excepciones para saber exactamente que cosa esta fallando
 * Así logrando una excepcion propia del proyecto
 */
@Getter
public class  ApiException extends Exception {

    private static final long serialVersionUID = 3980287382237745392L;

    private String message;
    private HttpStatus httpStatus;

    public ApiException(String message, HttpStatus httpStatus) {
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }

    @Override
    public String toString() {
        return message;
    }
}
