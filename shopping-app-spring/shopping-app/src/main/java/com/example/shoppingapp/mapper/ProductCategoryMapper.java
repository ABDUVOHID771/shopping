package com.example.shoppingapp.mapper;

import com.example.shoppingapp.dao.domain.ProductCategory;
import com.example.shoppingapp.dto.ProductCategoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface ProductCategoryMapper extends BaseMapper<ProductCategoryDto, ProductCategory> {
}
