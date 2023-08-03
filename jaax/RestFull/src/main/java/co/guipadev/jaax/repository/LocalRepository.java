package co.guipadev.jaax.repository;

import aj.org.objectweb.asm.Opcodes;
import co.guipadev.jaax.entity.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.OptionalInt;

public interface LocalRepository extends JpaRepository<Local, Long> {

    // Consulta con JPQL
    @Query("SELECT l FROM Local l WHERE l.name = :name")
    Optional<Local> findLocalByNameWithJPQL(String name);

    // Consulta con Inversión de Control
    Optional<Local> findByName(String name);
    Optional<Local> findByNameIgnoreCase(String name);
}
