package yadev.persona.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yadev.persona.entitys.Pais;
import yadev.persona.services.PaisService;

import java.util.List;

// @CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping ("/pais/")
public class PaisController {

    @Autowired
    private PaisService paisService;

    @GetMapping
    private ResponseEntity<List<Pais>> getAllPaises() {
        return ResponseEntity.ok(paisService.findAll());
    }
}
