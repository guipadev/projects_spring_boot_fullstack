package com.api.rest.party.controller;


import com.api.rest.party.entitys.Habilidad;
import com.api.rest.party.repository.HabilidadRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/habilidades")
public class HabilidadController {

    private HabilidadRepository habilidadRepository;

    @GetMapping
    public ResponseEntity<Collection<Habilidad>> listarHabilidades() {
        return new ResponseEntity<>(habilidadRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Habilidad> consultarHabilidadPorId(@PathVariable Long id) {
        Habilidad habilidad = habilidadRepository.findById(id).orElseThrow();

        if(habilidad != null) {
            return new ResponseEntity<>(habilidadRepository.findById(id).orElseThrow(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> guardarHabilidad(@RequestBody Habilidad habilidad) {
        return new ResponseEntity<>(habilidadRepository.save(habilidad), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAbility(@PathVariable Long id) {
        habilidadRepository.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
