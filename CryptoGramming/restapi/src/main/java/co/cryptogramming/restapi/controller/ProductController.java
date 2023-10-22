package co.cryptogramming.restapi.controller;

import co.cryptogramming.restapi.domain.Product;
import co.cryptogramming.restapi.dto.ProductDTO;
import co.cryptogramming.restapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Capa que tiene la responsabilidad de recibir todas las peticiones de nuestra
 * API
 * GET, POST, DELETE, UPDATE, en esta caso para los productos
 */
@RequiredArgsConstructor
@RestController // Indicar que esta clase va a ser usada para recibir peticiones HTTP
public class ProductController {

    // Esta referencia sera inyectada como dependencia en la clase
    private final ProductService productService;

    /**
     * Cuando ser reciba solicitud GET por endpoint /product, se invoca método
     * getPoducts()
     * value nombre del endpoint y produces que indica que la rta sera formato JSON
     * 
     * @return devuelve lista de todos los productos
     */
    @GetMapping(value = "/products", produces = "application/json")
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

    /**
     * Es un metodo POST, endpoint nombre products, se recibe un objeto que queremoscrear
     * @param productDTO recibe el body de este tipo
     * @return retorna objeto de tipo reponse entity, indicando que el producto ha sido creado
     */
    @PostMapping(value = "/product")
    public ResponseEntity saveProduct(@RequestBody ProductDTO productDTO) {
        productService.createProduct(productDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }


    @PutMapping(value ="/{productId}")
    public ResponseEntity updateProduct(@PathVariable int productId, @RequestBody ProductDTO productDTO) {
        productService.updateProduct(productId, productDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{productId}")
    public ResponseEntity deleteProduct(@PathVariable int productId) {
        productService.deleteProduct(productId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
