package co.yom.jwt.back.dtos;

/**
 * Las credenciales DTO son solo para recepción, no se editara el contenido campo por campo
 * Los record son inmutables
 * @param login usuario
 * @param password clave
 */
public record CredentialsDto (String login, char[] password) { }
