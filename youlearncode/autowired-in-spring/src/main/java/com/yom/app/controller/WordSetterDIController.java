package com.yom.app.controller;

import com.yom.app.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Usando @Autowired en Setter
 * En primer lugar, dado que usaremos setters para inyectar nuestro bean de servicio,
 * no podemos configurar el bean como final (al contrario de la inyección del constructor).
 * Además, ahora estamos obligados a utilizar la @Autowired anotación, de lo contrario
 * el objeto sería null.
 */
@RestController
@Profile("setter")
public class WordSetterDIController {

    private WordService wordService;

    @Autowired
    public void setWordService(WordService wordService) {
        this.wordService = wordService;
    }

    @GetMapping("/words")
    public List<String> getAll(){
        return wordService.getAllWords();
    }
}
