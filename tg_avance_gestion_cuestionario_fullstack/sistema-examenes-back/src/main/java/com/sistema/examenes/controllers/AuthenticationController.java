package com.sistema.examenes.controllers;

import com.sistema.examenes.configurations.JwtUtils;
import com.sistema.examenes.models.JwtRequest;
import com.sistema.examenes.models.JwtResponse;
import com.sistema.examenes.services.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtils jwtUtils;

    // Debe ser igual a la ruta del archivo de configuracion MySecurityConfig
    @PostMapping("/generate-token")
    public ResponseEntity<?> generationToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        try{
            authenticateUser(jwtRequest.getUsername(),jwtRequest.getPassword());
        }catch (Exception exception){
            exception.printStackTrace();
            throw new Exception("Usuario no encontrado");
        }

        UserDetails userDetails =  this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticateUser(String username,String password) throws Exception {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }catch (DisabledException exception){
            throw  new Exception("USUARIO DESHABILITADO " + exception.getMessage());
        }catch (BadCredentialsException e){
            throw  new Exception("Credenciales invalidas " + e.getMessage());
        }
    }

    //@GetMapping("/actual-usuario")
    //public User obtenerUsuarioActual(Principal principal){
    //    return (User) this.userDetailsService.loadUserByUsername(principal.getName());
    //}
}
