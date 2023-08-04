package co.guipadev.jaax.repository;

import co.guipadev.jaax.entity.Local;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest // clase persitencia a bd jpa
class LocalRepositoryTest {

    @Autowired
    LocalRepository localRepository;

    @Autowired
    TestEntityManager testEntityManager;

    // Ejecutar antes de las pruebas unitarias, todo este metodo
    @BeforeEach
    void setUp() {
        // Autoconfigure bd en memoria: se mapie como entidad y tabla, e ingresar datos
        Local local =
                Local.builder()
                        .name("Almacenes exito")
                        .floor("Granos")
                        .code("ex001")
                        .build();
        testEntityManager.persist(local);
    }

    // Escenario real si se encuentra en BD datos
    @Test
    void findLocalByNameIgnoreCaseFound() {
        Optional<Local> local = localRepository.findByNameIgnoreCase("Almacenes exito");
        assertEquals(local.get().getName(), "Almacenes exito");
        // imprimir dato que esta bd en memoria
        System.out.println("local.get() = " + local.get());
    }

    // Escenario en que no encuentre valor en BD
    @Test
    void findLocalByNameIgnoreCaseNotFound() {
        Optional<Local> local = localRepository.findByNameIgnoreCase("Cine Mark");
        assertEquals(local, Optional.empty());
    }

    @Test
    void findByName() {
    }


}