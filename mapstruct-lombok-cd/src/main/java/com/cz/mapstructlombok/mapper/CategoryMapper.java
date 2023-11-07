package com.cz.mapstructlombok.mapper;

import com.cz.mapstructlombok.dto.GetCategory;
import com.cz.mapstructlombok.entity.Category;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

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
