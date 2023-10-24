package co.yom.crud.configuration.constant;

/**
 * Tener CONSTANTES generales para la aplicación y ENUM
 */
public class AppConstant {

    /**
     * Al final solo deseamos solamente la var aqui declarada osea:
     * AppConstant.VERSION;
     * Así obteniendo var globales
     */
    public static final String VERSION = "1.0.0";

    /**
     * Constructor privado para declarar las constantes
     * Así evitamos que esta clase instancie al tener el constructor privado
     */
    private AppConstant() {}
}
