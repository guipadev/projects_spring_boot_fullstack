package co.yom.crud.model.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class RegisterBookDto {

    private String title;
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate publicationDate;
    
    @Builder.Default
    private Boolean onlineAvailability = false;
    
    private List<Integer> authors;
    
}
