package com.yom.cors.back.controllers;

import com.yom.cors.back.dtos.ContentDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {

    //Lo malo de esto es que tenemos que incluir la anotación CrossOrigin en todos los puntos finales
    //@CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/greetings")
    public ResponseEntity<ContentDto> greetings() {
        return ResponseEntity.ok(new ContentDto("Hello from backend!"));
    }
}
