package co.yom.crud.persistence.entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "books")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Book implements Serializable {

    private static final long serialVersionUID = 2426757912628209071L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;
    
    private String title;
    
    private LocalDate publicationDate;
    
    @Builder.Default
    private Boolean onlineAvailability = false;
}
