package co.cryptogramming.restapi.service;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import co.cryptogramming.domain.Product;
import co.cryptogramming.restapi.dto.ProductDTO;
//import co.cryptogramming.domain.Product;
//import co.cryptogramming.domain.model.CrudService;
import co.cryptogramming.restapi.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductService /* implements CrudService<Product> */ {

    private final ProductRepository repository;

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public void createProduct(ProductDTO productDTO) {

        Product product = new Product(
                productDTO.getId(),
                productDTO.getImagePath(),
                productDTO.getTitle(),
                productDTO.getDescription());

        repository.save(product);
    }

    /*
     * @Override
     * public void create(Product product) {
     * repository.save(product);
     * }
     * 
     * @Override
     * public void update(String id, Product product) {
     * }
     * 
     * @Override
     * public void delete(String id) {
     * }
     * 
     * @Override
     * public Collection<Product> getItem() {
     * return null;
     * }
     * 
     * @Override
     * public List<Product> getAllItems() {
     * return repository.findAll();
     * }
     */
}