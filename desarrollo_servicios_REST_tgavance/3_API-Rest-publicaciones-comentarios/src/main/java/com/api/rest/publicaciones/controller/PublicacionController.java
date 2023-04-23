package com.api.rest.publicaciones.controller;

import com.api.rest.publicaciones.entitys.Publicacion;
import com.api.rest.publicaciones.repository.PublicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class PublicacionController {

    @Autowired
    private PublicacionRepository publicacionRepository;

    @GetMapping("/publicaciones")
    public Page<Publicacion> listarPublicaciones(Pageable pageable) {
        return publicacionRepository.findAll(pageable);
    }


    @PostMapping("/publicaciones")
    public Publicacion guardarPublicacion(@Valid @RequestBody Publicacion publicacion) {
        return publicacionRepository.save(publicacion);
    }

    @PutMapping("/publicaciones/{publicacionId}")
    public Publicacion actualizarPublicacion(@PathVariable Long publicacionId, @Valid @RequestBody Publicacion publicacionRequest) {
        return publicacionRepository.findById(publicacionId).map(publicacion -> {
            publicacion.setTitulo(publicacionRequest.getTitulo());
            publicacion.setDescripcion(publicacionRequest.getDescripcion());
            publicacion.setContenido(publicacionRequest.getContenido());

            return publicacionRepository.save(publicacion);
        }).orElseThrow(() -> new RuntimeException("Publicacione con el ID : " + publicacionId + " no encontrada"));
    }

}