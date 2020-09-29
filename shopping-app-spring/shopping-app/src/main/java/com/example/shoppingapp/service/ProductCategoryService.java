package com.example.shoppingapp.service;

import com.example.shoppingapp.dao.domain.ProductCategory;
import com.example.shoppingapp.dao.repository.ProductCategoryRepository;
import com.example.shoppingapp.dto.ProductCategoryDto;
import com.example.shoppingapp.mapper.ProductCategoryMapper;
import org.springframework.stereotype.Service;

@Service
public class ProductCategoryService extends BaseService<ProductCategoryRepository, ProductCategoryMapper, ProductCategoryDto, ProductCategory> {

    public ProductCategoryService(ProductCategoryRepository repository, ProductCategoryMapper mapper) {
        super(repository, mapper);
    }

}
