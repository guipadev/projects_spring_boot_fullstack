package com.yom.app.service;

import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

/**
 * Creamos un paquete ficticio WordService
 * Acabamos de crear un bean usando la @Service anotación que luego se inyectará
 * usando la anotación @Autowired.
 */
@Service
public class WordService {

    private final List<String> words = Arrays.asList("Code", "Learn", "Hub");

    public List<String> getAllWords(){
        return words;
    }
}
