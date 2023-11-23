package com.yom.app.controller;

import com.yom.app.service.LetterService;
import com.yom.app.service.WordService;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Usando @Autowired en Constructor
 */
@RestController
@Profile("constructor")
public class WordConstructorDIController {

    /**
     * Aquí simplemente creamos un controlador Rest e inyectamos la WordServicedependencia
     * creando un miembro wordservice que es privado
     * (ya que no necesitamos que se nos acceda a ningún otro lugar que no sea esta clase)
     * y final (ya que no queremos que este objeto se cambie en absoluto).
     *
     * Nuevamente, tenga en cuenta que en este caso especial, que se @Autowired aplica a un
     * constructor, en realidad no necesitamos esta anotación desde Spring 4.2.
     *
     * Como puede observar, queda lo más claro posible qué dependencias tiene esta clase.
     */
    private final WordService wordService;

    /**
     * Además, si quisiéramos agregar otro servicio a esta clase, digamos un LetterService,
     * agregaríamos solo lo siguiente:
     */
    private final LetterService letterService;

    // Funciona con o sin @Autowired
    public WordConstructorDIController(WordService wordService, LetterService letterService) {
        this.wordService = wordService;
        this.letterService = letterService;
    }

    @GetMapping("/words")
    public List<String> getAll(){
        return wordService.getAllWords();
    }
}
