package co.yom.jwt.back.dtos;

public record SignUpDto (String firstName, String lastName, String login, char[] password) { }
