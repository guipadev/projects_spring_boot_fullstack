package co.yom.jwt.back.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import co.yom.jwt.back.dtos.UserDto;
import co.yom.jwt.back.services.UserService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Collections;
import java.util.Date;

// Clase proveedor que creará y validará el JWT
// Solo el back puede codificar y decodificar el JWT
@RequiredArgsConstructor
@Component
public class UserAuthenticationProvider {

    // Clave secreta
    @Value("${security.jwt.token.secret-key:secret-key}")
    private String secretKey;

    private final UserService userService;

    @PostConstruct
    protected void init() {
        // se evita tener clave secreta disponible en la JVM
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    // Método para crear el token
    public String createToken(UserDto user) {
        Date now = new Date();

        // Esto corresponde a 1 hora
        Date validity = new Date(now.getTime() + 3600000);

        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        // Dentro del JWT almaceno el login, fecha creación y fecha de validez
        // Se agregan claims personalizados como nombre y apellido
        return JWT.create()
                .withSubject(user.getLogin())
                .withIssuedAt(now)
                .withExpiresAt(validity)
                .withClaim("firstName", user.getFirstName())
                .withClaim("lastName", user.getLastName())
                .sign(algorithm);
    }

    // Método para validar token
    // Se usa la información en el JWT para crear un DTO de usuario con login, nombre y apellido
    public Authentication validateToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        JWTVerifier verifier = JWT.require(algorithm)
                .build();

        DecodedJWT decoded = verifier.verify(token);

        UserDto user = UserDto.builder()
                .login(decoded.getSubject())
                .firstName(decoded.getClaim("firstName").asString())
                .lastName(decoded.getClaim("lastName").asString())
                .build();

        return new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
    }

    // Método para decodificar el token
    public Authentication validateTokenStrongly(String token) {
        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        JWTVerifier verifier = JWT.require(algorithm)
                .build();

        DecodedJWT decoded = verifier.verify(token);

        UserDto user = userService.findByLogin(decoded.getSubject());

        // Devuelvo un bean de autenticación
        return new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
    }

}
