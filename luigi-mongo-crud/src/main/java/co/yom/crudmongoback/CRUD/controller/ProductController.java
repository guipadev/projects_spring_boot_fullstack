package co.yom.crudmongoback.CRUD.controller;

import co.yom.crudmongoback.CRUD.service.ProductService;
import co.yom.crudmongoback.CRUD.dto.ProductDto;
import co.yom.crudmongoback.CRUD.entity.Product;
import co.yom.crudmongoback.global.exceptions.AttributeException;
import co.yom.crudmongoback.global.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {

        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getOne(@Valid @PathVariable("id") int id) throws ResourceNotFoundException {
        return ResponseEntity.ok(productService.getOne(id));
    }

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody ProductDto dto) throws AttributeException {
        return ResponseEntity.ok(productService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable("id") int id, @Valid @RequestBody ProductDto dto) throws ResourceNotFoundException, AttributeException {
        return ResponseEntity.ok(productService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable("id") int id) throws ResourceNotFoundException {
        return ResponseEntity.ok(productService.delete(id));
    }
}
