package co.yom.crudmongoback.CRUD.service;

import co.yom.crudmongoback.CRUD.dto.ProductDto;
import co.yom.crudmongoback.CRUD.entity.Product;
import co.yom.crudmongoback.global.exceptions.AttributeException;
import co.yom.crudmongoback.global.exceptions.ResourceNotFoundException;

import java.util.List;

public interface IProductService {

    public List<Product> getAll();

    public Product getOne(int id) throws ResourceNotFoundException;

    public Product save(ProductDto dto) throws AttributeException;

    public Product update(int id, ProductDto dto) throws ResourceNotFoundException, AttributeException;
    public Product delete(int id) throws ResourceNotFoundException;

     int autoIncrement();
}
