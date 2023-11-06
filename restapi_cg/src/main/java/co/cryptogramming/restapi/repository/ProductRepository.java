package co.cryptogramming.restapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import co.cryptogramming.restapi.domain.Product;

/**
 * Interfaz con anotacion repository indicando al framework que se va a interactuar
 * con alguna fuente de datos y esta extiende de MongoRepository ya que esta interfaz
 * provee muchos métodos para interactuar con la BD de Mongo
 */
@Repository
public interface ProductRepository extends MongoRepository<Product, Integer> {

}