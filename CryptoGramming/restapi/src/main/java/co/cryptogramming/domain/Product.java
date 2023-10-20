package co.cryptogramming.domain;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Document(collection = "Product")
public class Product implements Serializable {

    @Id
    @NonNull
    private int id;
    private String imagePath;
    private String title;
    private String description;

}