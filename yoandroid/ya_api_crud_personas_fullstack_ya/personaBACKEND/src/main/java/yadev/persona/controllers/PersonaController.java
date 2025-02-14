package yadev.persona.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yadev.persona.entitys.Persona;
import yadev.persona.services.Impl.PersonaServiceImpl;

import java.net.URI;
import java.util.List;

// @CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/personas/")
public class PersonaController {

    @Autowired
    private PersonaServiceImpl personaService;

    @GetMapping
    private ResponseEntity<List<Persona>> getAllPersonas () {
        return ResponseEntity.ok(personaService.findAll());
    }

    @PostMapping
    private ResponseEntity<Persona> savePersona (@RequestBody Persona persona) {
        try {
            Persona personaGuardada = personaService.save(persona);
            return ResponseEntity.created(new URI("/personas/"+personaGuardada.getId())).body(personaGuardada);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping (value = "delete/{id}")
    private ResponseEntity<Boolean> deletePersona (@PathVariable ("id") Long id) {
        personaService.deleteById(id);
        return ResponseEntity.ok(!(personaService.findById(id) != null));
    }
}
