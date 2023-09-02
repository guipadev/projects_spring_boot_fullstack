package com.yao.productservice.controller;

import com.yao.productservice.entity.ProductEntity;
import com.yao.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    /*
    // Como se hace sin no se aplicara el REsponseStatus
    @GetMapping
    public List<ProductEntity<List<ProductEntity>> getAllProducts() {
        List<ProductEntity> productEntities = productRepository.findAll();
        ResponseEntity<List<ProductEntity>> responseEntity = new ResponseEntity<>(productEntities, HttpStatus.ok);
        return responseEntity;
    }
     */

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ProductEntity createProduct(@RequestBody ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }
}