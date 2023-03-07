package com.mongo.angular.crudmongo.CRUD.repository;

import com.mongo.angular.crudmongo.CRUD.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, Integer> {
}