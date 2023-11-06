package com.cazadordigital.mapstructlombokdemo.mapper;

import com.cazadordigital.mapstructlombokdemo.dto.GetCategory;
import com.cazadordigital.mapstructlombokdemo.entity.Category;
import com.cazadordigital.mapstructlombokdemo.repository.CategoryRepository;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    public CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    @Mappings({
            @Mapping(source = "id", target = "categoryId"),
            @Mapping(source = "name", target = "categoryName")
    })
     GetCategory toGetCategory(Category category);

    @InheritInverseConfiguration
     Category toEntity(GetCategory getCategory);

     List<GetCategory> toGetCategoryList(List<Category> categoryList);

     List<Category> toEntityList(List<GetCategory> getCategoryList);

}
