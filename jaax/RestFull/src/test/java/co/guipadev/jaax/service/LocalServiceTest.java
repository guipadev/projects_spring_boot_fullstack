package co.guipadev.jaax.service;

import co.guipadev.jaax.entity.Local;
import co.guipadev.jaax.repository.LocalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class) // Cargar solo la capa de persistencia
class LocalServiceTest {

    @Mock
    private LocalRepository localRepository;

    @InjectMocks
    private LocalServiceImpl localService;

    @BeforeEach
    void setUp() {
        //MockitoAnnotations.openMocks(this);

        Local local = Local.builder()
                .id(1L)
                .name("PetShop")
                .floor("Second Floor")
                .code("Pet-050-2")
                .build();
        Mockito.when(localRepository.findByNameIgnoreCase("PetShop")).thenReturn(Optional.of(local));
    }

    // Simular local Repository que el anterior objeto es de la BD real
    @Test
    @DisplayName("Prueba de obtención de información de un local enviando un nombre válido")
    public void findByNameIgnoreCaseShouldFound(){
        String localName = "PetShop";
        Local local = localService.findByNameIgnoreCase(localName).get();
        assertEquals(localName,local.getName());
        System.out.println("local = " + local);
    }
/*
    @Test
    public void testFindAllLocals() {
        // Datos de prueba
        List<Local> locals = new ArrayList<>();
        locals.add(new Local(1L, "Local 1", "First Floor", "Code-001"));
        locals.add(new Local(2L, "Local 2", "Second Floor", "Code-002"));

        // Configurar el comportamiento del mock
        when(localRepository.findAll()).thenReturn(locals);

        // Realizar la llamada al método del servicio
        List<Local> result = localService.findAllLocals();

        // Verificar el resultado
        assertEquals(locals, result);
    }

    @Test
    public void testSaveLocal() {
        // Datos de prueba
        Local localToSave = new Local();
        localToSave.setName("New Local");
        localToSave.setFloor("Third Floor");
        localToSave.setCode("Code-003");

        // Configurar el comportamiento del mock
        when(localRepository.save(localToSave)).thenReturn(localToSave);

        // Realizar la llamada al método del servicio
        Local savedLocal = localService.saveLocal(localToSave);

        // Verificar el resultado
        assertNotNull(savedLocal);
        assertEquals(localToSave.getName(), savedLocal.getName());
    }
*/
}