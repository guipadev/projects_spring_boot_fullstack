package com.cz.mapstructlombok.test;

import com.cz.mapstructlombok.dto.GetProduct;
import com.cz.mapstructlombok.entity.Product;
import com.cz.mapstructlombok.mapper.ProductMapper;
import com.cz.mapstructlombok.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class InitDatabase {

    @Autowired
    private ProductRepository productRepository;

    private ProductMapper productMapper = ProductMapper.INSTANCE;

    @Bean
    public CommandLineRunner testProductMapperCommand(){

        return args -> {

            List<Product> products = productRepository.findAll();

            System.out.println("PRODUCTS");
            products.forEach(System.out::println);

            System.out.println("GET PRODUCTS");
            List<GetProduct> getProductList = productMapper.toGetProductList(products);
            getProductList.forEach(System.out::println);

            System.out.println("MAPPED PRODUCTS");
            List<Product> mappedProducts = productMapper.toEntityList(getProductList);
            mappedProducts.forEach(System.out::println);

        };

    }

}
