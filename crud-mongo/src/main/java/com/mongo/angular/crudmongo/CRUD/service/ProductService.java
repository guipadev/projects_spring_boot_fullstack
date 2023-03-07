package com.mongo.angular.crudmongo.CRUD.service;

import com.mongo.angular.crudmongo.CRUD.dto.ProductDto;
import com.mongo.angular.crudmongo.CRUD.entity.Product;
import com.mongo.angular.crudmongo.CRUD.repository.ProductRepository;
import com.mongo.angular.crudmongo.global.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product getOne(int id) throws ResourceNotFoundException {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
    }

    public Product save(ProductDto dto) {
        int id = autoIncrement();
        Product product = new Product(id, dto.getName(), dto.getPrice());
        return productRepository.save(product);
    }

    public Product update(int id, ProductDto dto) {
        Product product = productRepository.findById(id).get();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());

        return productRepository.save(product);
    }

    public Product delete(int id) {
        Product product = productRepository.findById(id).get();
        productRepository.delete(product);

        return product;
    }

    // private methods
    private int autoIncrement() {
        List<Product> products = productRepository.findAll();

        return products.isEmpty()
                ? 1
                : products.stream().max(Comparator.comparing(Product::getId)).get().getId() + 1;
    }
}
