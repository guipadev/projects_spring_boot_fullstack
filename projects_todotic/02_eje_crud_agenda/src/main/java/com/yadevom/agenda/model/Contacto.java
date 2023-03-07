package com.yadevom.agenda.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Contacto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idcontacto")
    private Integer id;
    @NotBlank
    private String nombre;
    @NotNull
    @Past
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name="fechanac")
    private LocalDate fechaNacimiento;
    @NotBlank
    @Size(max = 15)
    private String celular;
    @NotEmpty
    @Email
    private String email;

}
