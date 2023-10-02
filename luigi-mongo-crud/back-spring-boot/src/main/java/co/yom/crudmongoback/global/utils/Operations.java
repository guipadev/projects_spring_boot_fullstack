package co.yom.crudmongoback.global.utils;

public class Operations {

    public static String trimBrackets(String message) {
        // Quitar caracteres especiales
        return message.replaceAll("[\\[\\]]", "");
    }
}