package co.cryptogramming.restapi.domain;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "Product")
public class Product implements Serializable {

    @Id
    @NonNull
    private Integer id;
    private String imagePath;
    private String title;
    private String description;

    public Product(@NonNull Integer id, String imagePath, String title, String description) {
        this.id = id;
        this.imagePath = imagePath;
        this.title = title;
        this.description = description;
    }
}