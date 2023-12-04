package co.yom.exception;

public class DemoSpringException extends Exception {

    private static final long serialVersionUID = -7095147998863479282L;

    private ExceptionDetails details;

    /*
    Cuando hacemos catch de una excepción y necesitamos una nueva excepción debemos enviar
    la excepción anterior, para cuando hagamos el log en toda la traza, se muestre de dónde
    es el origen de nuestro error
    Eliminar o quitar la traza de las excepciones es una mala práctica
     */
    public DemoSpringException(String message, ExceptionDetails details, Throwable e) {
        super(message, e);
        setDetails(details);
    }

    public DemoSpringException(String message, ExceptionDetails details) {
        super(message);
        setDetails(details);
    }
    public ExceptionDetails getDetails() {
        return details;
    }

    public void setDetails(ExceptionDetails details) {
        this.details = details;
    }
}
