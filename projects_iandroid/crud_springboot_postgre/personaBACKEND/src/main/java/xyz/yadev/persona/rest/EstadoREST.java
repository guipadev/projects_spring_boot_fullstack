package xyz.yadev.persona.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.yadev.persona.model.Estado;
import xyz.yadev.persona.service.EstadoService;

import java.util.List;

// @CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping ("/estados/")
public class EstadoREST {

    @Autowired
    private EstadoService estadoService;

    // Mostrar solo lo estados de acuerdo al país
    @GetMapping ("{id}")
    private ResponseEntity<List<Estado>> getAllEstadosByPais (@PathVariable("id") Long idPais){
        return ResponseEntity.ok(estadoService.findAllByCountry(idPais));
    }
}
