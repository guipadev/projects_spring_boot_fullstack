package co.yom.crudmongoback.CRUD.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "products")
public class Product {

    @Id
    private int id;
    private String name;
    private int price;
}
