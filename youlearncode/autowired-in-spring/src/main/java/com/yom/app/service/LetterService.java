package com.yom.app.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class LetterService {

    private final List<Character> letters = Arrays.asList('C', 'L', 'H');

    public List<Character> getAllLetters(){
        return letters;
    }

}
