package com.cazadordigital.mapstructlombokdemo.dto;

import com.cazadordigital.mapstructlombokdemo.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetCategory {

    private long categoryId;
    private String categoryName;

}
