package co.yom.jwt.back.controllers;


import lombok.RequiredArgsConstructor;

import co.yom.jwt.back.config.UserAuthenticationProvider;
import co.yom.jwt.back.dtos.CredentialsDto;
import co.yom.jwt.back.dtos.SignUpDto;
import co.yom.jwt.back.dtos.UserDto;
import co.yom.jwt.back.services.UserService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RequiredArgsConstructor
@RestController
public class AuthController {

    private final UserService userService;
    private final UserAuthenticationProvider userAuthenticationProvider;


    /**
    * Con el endpoint de inicio de sesión
    * Credenciales DTO se creara como un Record
    * Devolvera un DTO y recibira otro DTO como JSON
    * En el interior se llama un servicio con el método de inicio de sesión
    * Y devolverá directamente el UserDto**/
    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody @Valid CredentialsDto credentialsDto) {
        UserDto userDto = userService.login(credentialsDto);
        // Devuelve un nuevo token
        userDto.setToken(userAuthenticationProvider.createToken(userDto));
        return ResponseEntity.ok(userDto);
    }


    /**
     * El endpoint devuelve un UserDTO
     * Pero como entrada se tiene un SignUpDTO
     * Se llama al método de registro desde el servicio
     * Y devuelve una respuesta creada que contenga la URL de la entidad creada
     * @param user
     * @return
     */
    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody @Valid SignUpDto user) {
        UserDto createdUser = userService.register(user);
        createdUser.setToken(userAuthenticationProvider.createToken(createdUser));
        return ResponseEntity.created(URI.create("/users/" + createdUser.getId())).body(createdUser);
    }

}
