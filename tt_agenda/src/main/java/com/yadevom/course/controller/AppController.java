package com.yadevom.course.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping("hola-mundo")
    String index() {
        return "index";
    }

}
