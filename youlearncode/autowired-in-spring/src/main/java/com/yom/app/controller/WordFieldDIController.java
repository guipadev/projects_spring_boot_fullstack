package com.yom.app.controller;

import com.yom.app.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Profile("field")
public class WordFieldDIController {

    /**
     * Como puedes observar, en ese caso, simplemente agregamos @Autowired encima del bean
     * que queremos inyectar.
     * Como antes, no podemos configurar el bean como final, ya que no tenemos ningún constructor
     * y no hay forma de garantizar que esta variable no cambie de referencia.
     */
    @Autowired
    private WordService wordService;

    @GetMapping("/words")
    public List<String> getAll(){
        return wordService.getAllWords();
    }
}
