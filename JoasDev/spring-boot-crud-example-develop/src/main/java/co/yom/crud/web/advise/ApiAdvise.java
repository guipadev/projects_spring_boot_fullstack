package co.yom.crud.web.advise;

import co.yom.crud.web.util.ResponseMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import co.yom.crud.exception.ApiException;

/**
 * Poder controlar los status
 */
@RestControllerAdvice
public class ApiAdvise {

    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity<ResponseMessage<Void>> getException(ApiException exception) {

        /**
         * Enviamos un void que es un tipo que no existe, lo cual indico no hagas nada
         * simplemente devuelve el mensaje
         * Hacemos uso del patron builder que llama a la clase
         * Y mandamos el mjs recibido en el parametro exception
         */
        ResponseMessage<Void> msg = ResponseMessage.<Void>builder()
                .message(exception.getMessage())
                .build();

        /**
         * Envía el contenido que quiere que salga de tu endpoint y envia el status osea cabecera y header
         * Osea body para darle un cuerpo o salida que queramos del endpoint, y para darle un estado 400, 401...
         */
        return new ResponseEntity<>(msg, exception.getHttpStatus());
    }

    /**
     * Aquí podriamos crear otro @ExceptionHandler para otro tipo excepción
     */
}
