package co.yadev.libro.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor // creara constructor con el argumento obligatrio titulo
@NoArgsConstructor
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NonNull
    private String titulo;
    private LocalDateTime fechaCreacion;

    // Crear fecha automaticamente cuando se persista
    @PrePersist
    private void asignarFechaCreacion() {
        fechaCreacion = LocalDateTime.now();
    }

}

