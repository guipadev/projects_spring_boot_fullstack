package co.guipadev.jaax.controller;

import co.guipadev.jaax.entity.Greeting;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s";

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting helloWorld(@RequestParam(value = "name", defaultValue = "Wordl") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
