package co.cryptogramming.restapi.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
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
    private String distributor;
    private Date releaseDate;
}