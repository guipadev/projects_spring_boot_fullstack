package com.sistema.examenes.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Cuando se responda se devuelve el token
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class JwtResponse {

    private String token;
}