package com.yomdev.app.security.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.*;

public class TokenUtils {

    private final static String ACCESS_TOKEN_SECRET = "4qhq8LrEBfYcaRHxhdb9zURb2rf8e7Ud";
    private final static Long ACCESS_TOKEN_VALIDATY_SECONDS = 2_592_000L;

    //Token envio de datos para acceso
    public static String createToken(String nombre, String email) {
        long expirationTime = ACCESS_TOKEN_VALIDATY_SECONDS * 1000;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);

        //Data adicional para el token
        Map<String, Object> extra = new HashMap<>();
        extra.put("nombre", nombre);

        //Construcción del token
        return Jwts.builder()
                .setSubject(email)
                .setExpiration(expirationDate)
                .addClaims(extra)
                .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
                .compact();
    }

    //Método retornar username y password autentication token que sea valido para que Spring Security reconozca
    //Y pueda pasar el proceso de autorización de un usuario que intenta acceder a un endpoint mediante token
    //El token va estar en un formato plano
    public static UsernamePasswordAuthenticationToken getAuthentication(String token) {
        try {
            //Recibir token cliente
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            //Extaer correo
            String email = claims.getSubject();

            return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());
        } catch (JwtException e) {
            return null;
        }
    }
}
