package com.cazadordigital.mapstructlombokdemo.mapper;

import com.cazadordigital.mapstructlombokdemo.dto.GetProduct;
import com.cazadordigital.mapstructlombokdemo.entity.Product;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {CategoryMapper.class})
public interface ProductMapper {

    public ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mappings( {
            @Mapping(source = "creationDate", target = "creationDate",
                    dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(source = "name", target = "productName"),
            @Mapping(source = "id", target = "productId"),
            @Mapping(source = "category", target = "productCategory"),
            @Mapping(source = "price", target = "price", numberFormat = "$0.00"),

    } )
    GetProduct toGetDTO(Product product);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "creationDate", ignore = true)
    })
    Product toEntity(GetProduct getProduct);

    List<GetProduct> toGetProductList(List<Product> productList);

    List<Product> toEntityList(List<GetProduct> getProductList);

}
