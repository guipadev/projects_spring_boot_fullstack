package co.yom.crudmongoback.CRUD.service;

import co.yom.crudmongoback.CRUD.dto.ProductDto;
import co.yom.crudmongoback.CRUD.entity.Product;
import co.yom.crudmongoback.CRUD.repository.ProductRepository;
import co.yom.crudmongoback.global.exceptions.AttributeException;
import co.yom.crudmongoback.global.exceptions.ResourceNotFoundException;
import co.yom.crudmongoback.global.utils.Operations;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final ProductRepository productRepository;

    public List<Product> getAll() {

        return productRepository.findAll();
    }

    public Product getOne(int id) throws ResourceNotFoundException {

        //return productRepository.findById(id).get();

        return productRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("not found"));
    }

    public Product save(ProductDto dto) throws AttributeException {
        if(productRepository.existsByName(dto.getName()))
            throw new AttributeException("Ya existe un producto con dicho nombre");

        int id = Operations.autoIncrement(productRepository.findAll());
        Product product = new Product(dto.getName(), dto.getPrice());
        return productRepository.save(product);
    }

    public Product update(int id, ProductDto dto) throws ResourceNotFoundException, AttributeException {
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No existe producto por Id"));

        if(productRepository.existsByName(dto.getName()) && productRepository.findByName(dto.getName()).get().getId() != id)
            throw new AttributeException("Nombre producto ya en uso!!");

        //Product product = productRepository.findById(id).get();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        return productRepository.save(product);
    }

    public Product delete(int id) throws ResourceNotFoundException {
        //Product product = productRepository.findById(id).get();
        //productRepository.delete(product);
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("este producto no se encuentra"));
        productRepository.delete(product);
        return product;
    }

}
