package co.cryptogramming.restapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import co.cryptogramming.domain.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, Integer> {

}