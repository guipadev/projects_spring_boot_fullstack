package com.yom.app.controller;

import com.yom.app.service.LetterService;
import com.yom.app.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Profile("parameter")
public class WordParameterController {

    /**
     * @Autowired en parametros del metodo y Optional Autowiring
     * Como puedes observar, pretendemos tener un wordServicecampo obligatorio y un campo
     * opcional letterService.
     * Si ejecutamos la aplicación, obtendremos un error
     * Esto es de esperar ya que no hemos agregado @Servicea la LetterService clase.
     * Sin embargo, puedes hacer que este bean sea opcional, simplemente cambiando el constructor
     *
     * Ahora, si ejecutamos nuevamente la aplicación, no obtendremos ningún error, aunque no
     * tengamos ningún bean de tipo LetterService, porque agregamos el archivo @Autowired
     * (required = false).
     *
     * Esto significa que si por alguna razón no se pudo crear una instancia del bean,
     * la aplicación no fallará.
     *
     * Ahora, si regresamos LetterService y agregamos la @Service anotación en la parte
     * superior, inicializaríamos nuestro letterService bean como se esperaba.
     */

    private final WordService wordService;
    private LetterService letterService;

    public WordParameterController(WordService wordService,
                                   @Autowired(required = false) LetterService letterService
    ) {
        this.wordService = wordService;
        this.letterService = letterService;
    }

    @GetMapping("/words")
    public List<String> getAll(){
        return wordService.getAllWords();
    }
}
