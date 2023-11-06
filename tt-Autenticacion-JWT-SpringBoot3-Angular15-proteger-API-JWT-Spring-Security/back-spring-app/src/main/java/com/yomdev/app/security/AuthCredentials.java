package com.yomdev.app.security;

// Recibir email y password

import lombok.Data;

@Data
public class AuthCredentials {
    private String email;
    private String password;
}
