package com.api.rest.publicaciones.controller;

import com.api.rest.publicaciones.entitys.Comentario;
import com.api.rest.publicaciones.entitys.Publicacion;
import com.api.rest.publicaciones.excepciones.ResourceNotFoundException;
import com.api.rest.publicaciones.repository.ComentarioRepository;
import com.api.rest.publicaciones.repository.PublicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ComentarioController {

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private PublicacionRepository publicacionRepository;

    // Una publicacion puede tener muchos comentarios, por lo cual muchos comentarios pueden pertenecerle a una publicacion
    @GetMapping("/publicaciones/{publicacionId}/comentarios")
    public Page<Comentario> listarComentariosPorPublicaciones(@PathVariable(value="publicacionId") Long publicacionId, Pageable pageable) {
        return comentarioRepository.findByPublicacionId(publicacionId, pageable);
    }


    @PostMapping("/publicaciones/{publicacionId}/comentarios")
    public Comentario guardarComentario(@PathVariable(value = "publicacionId") Long publicacionId, @Valid @RequestBody Comentario comentario) {
        return publicacionRepository.findById(publicacionId).map(publicacion -> {
            comentario.setPublicacion(publicacion);
            return comentarioRepository.save(comentario);
        }).orElseThrow(() -> new RuntimeException("Publicacione con el ID : " + publicacionId + " no encontrada"));
    }

    @PutMapping("/publicaciones/{publicacionId}/comentarios/{comentarioId}")
    public Comentario actualizarComentario(@PathVariable(value = "publicacionId") Long publicacionId, @PathVariable(value = "comentarioId") Long comentarioId, @Valid @RequestBody Comentario comentarioRequest) {
        if(!publicacionRepository.existsById(publicacionId)) {
            throw new ResourceNotFoundException("Publicacion con el ID : " + publicacionId + " no encontrada");
        }

        return comentarioRepository.findById(comentarioId).map(comentario -> {
            comentario.setTexto(comentarioRequest.getTexto());
            return comentarioRepository.save(comentario);
        }).orElseThrow(() -> new ResourceNotFoundException("Comentario con el ID : " + comentarioId + " no encontrada"));
    }

    @DeleteMapping("/publicaciones/{publicacionId}/comentarios/{comentarioId}")
    public ResponseEntity<?> eliminarComentario(@PathVariable(value = "publicacionId") Long publicacionId, @PathVariable(value = "comentarioId") Long comentarioId)  {
        return comentarioRepository.findByIdAndPublicacion(comentarioId, publicacionId).map(comentario -> {
            comentarioRepository.delete(comentario);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new RuntimeException("Comentario con el ID : " + comentarioId  + " no encontrado y publicación co el ID " + publicacionId + " no encontrada"));
    }
}

