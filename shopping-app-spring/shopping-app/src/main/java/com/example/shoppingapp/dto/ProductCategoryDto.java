package com.example.shoppingapp.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
public class ProductCategoryDto extends BaseDto {

    private String categoryName;
    private Set<ProductDto> products;
}
