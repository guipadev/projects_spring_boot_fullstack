package co.sd.controllers;

import co.sd.models.Persona;
import co.sd.services.impl.PersonaServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1")
@CrossOrigin({ "*" })
public class PersonaController {

    private final PersonaServiceImpl personaService;

    /**
     * Consultar todo los registros
     * El resultado de esta lista spring boot
     * @return retorna JSON
     */
    @GetMapping(value = "/all")
    public List<Persona> getAll() {
        return personaService.getAll();
    }

    /**
     * Actualizar o Guardar un nuevo registro
     * Si viene un ID predefinido actualiza el registro
     * Si no viene un ID, simplemente lo guarda
     * @param persona, cuerpo JSON
     * @return respuesta OK
     */
    @PostMapping("/save")
    public ResponseEntity<Persona> save(@RequestBody Persona persona) {
        Persona perso = personaService.save(persona);
        return new ResponseEntity<>(perso, HttpStatus.OK);
    }

    /**
     * Eliminar persona por Id
     * @param id identificación de persona
     * @return msj indicando si fu o no exitoso
     */
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Persona> delete(@PathVariable Long id) {
        Persona perso = personaService.get(id);

        if (perso != null) {
            personaService.delete(id);
        } else {
            return new ResponseEntity<>(perso, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return null;
    }
    @GetMapping("/find/{id}")
    public Persona find(@PathVariable Long id) {
       return personaService.get(id);
    }

}
