package yadev.persona.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import yadev.persona.entitys.Persona;
import yadev.persona.repositorys.IPersonaRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class PersonaServiceTest {

    @Mock
    private IPersonaRepository personaRepository;

    @InjectMocks
    private PersonaService personaService;

    // Crear metodo persona si se necesita en varios casos de prueba
    private Persona persona;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        persona = new Persona();
        persona.setId(new Long(1));
        persona.setNombre("Yo Androide");

    }

    // Vamos a simular el guardado
    // Cuando se llama el metodo save, devuelve una entidad
    @Test
    void save() {
        when(personaRepository.save(any(Persona.class))).thenReturn(persona);
        assertNotNull(personaService.save(new Persona()));
    }
}