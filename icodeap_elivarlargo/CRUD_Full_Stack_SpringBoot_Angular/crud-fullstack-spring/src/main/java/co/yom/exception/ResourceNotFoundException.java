package co.yom.exception;

//@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    // El msj que decidamos poner de acuerdo a la excepción
    private String message;

    public ResourceNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
