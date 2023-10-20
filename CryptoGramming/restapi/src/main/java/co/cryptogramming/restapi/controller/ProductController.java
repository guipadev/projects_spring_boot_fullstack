package co.cryptogramming.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.cryptogramming.domain.Product;
import co.cryptogramming.restapi.service.ProductService;
import lombok.RequiredArgsConstructor;

/**
 * Capa que tiene la responsabilidad de recibir todas las peticiones de nuestra
 * API
 * GET, POST, DELETE, UPDATE, en esta caso para los productos
 * 
 * @param <ProductDTO>
 */
@RequiredArgsConstructor
@RestController // Indicar que esta clase va a ser usada para recibir peticiones HTTP
public class ProductController<ProductDTO> {

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
        return productService.getAllItems();
    }

    /**
     * Es un metodo POST, endpoint nombre products, se recibe un objeto que queremos
     * crear
     * 
     * @param product recibe el body de este tipo
     * @return retorna objeto de tipo reponse entity, indicando que el producto a
     *         sido creado
     */
    @PostMapping(value = "/product")
    public ResponseEntity saveProduct(@RequestBody ProductDTO productDTO) {

        productService.create(productDTO);
        return new ResponseEntity(HttpStatus.OK);

    }

    @PutMapping(value ="/{productId}")
    public ResponseEntity updateProduct(@PathVariable int productId, @RequestBody ProductDTO productDTO) {

        productService.updateProduct(productId, productDTO);

        return new ResponseEntity(HttpStatus.OK);

    @DeleteMapping(value = "/{productId}")
    public ResponseEntity deleteProduct(@PathVariable int productId) {

        productService.delete(productId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
