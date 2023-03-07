package co.dev.apiaccount.documents;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@JsonInclude(JsonInclude.Include.NON_EMPTY) // No se acepten vacios en el JSON
@Data
@Document(collection = "acount")
public class Account {

    @Id
    private String id;

    private String fullName;

    private String identityDocumentNumber;

    private String identityDocumentType;

    private String phoneNumber;

    // Al crear la cuenta, se registre la fecha automaticamente
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdDate = LocalDateTime.now();
}
