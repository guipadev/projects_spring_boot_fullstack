package co.yom.crud.persistence.entity;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity
 * Para indicar que es una copia como esta la tablas en la BD
 *
 */
@Entity
// Recordar todas las tablas de BD deben estar en plural y no en singular ej. author a no ser que sea de muchos a muchos
@Table(name = "authors")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
// Serializable permite comprimir datos para viajar por la red
public class Author implements Serializable{

    /**
     * Lo crea el IDE, ya que esta serializable, este nos ayuda a crearlo
     * porque al realizarlo private static final long serialVersionUID = 1L; mala práctica
     */
    private static final long serialVersionUID = 2520773500635676241L;

    /**
     * Todos los entity tienen un ID, exceptuando los que son de muchos a muchos
     * Osea todo lo declarado con @Table tiene un ID
     */
	@Id
    // Auto generable, pero puede variar de acuerdo a motor BD
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer authorId;
    // @Column(name = "first_name_person") nombre campo debe ser igual a la tabla de la BD, tambien podemos definir tamaño y otras cosas
    // Pero este es un estandar firstName quiere indicar que en la BD esta como first_name
    private String firstName;
    private String lastName;

    // Definicion de las fechas con la libreria Json, solo indicamos el formato de fecha
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthdate;
    
}
