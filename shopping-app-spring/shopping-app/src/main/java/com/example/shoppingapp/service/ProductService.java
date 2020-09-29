package com.example.shoppingapp.service;

import com.example.shoppingapp.dao.domain.Product;
import com.example.shoppingapp.dao.repository.ProductRepository;
import com.example.shoppingapp.dto.ProductDto;
import com.example.shoppingapp.mapper.ProductMapper;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends BaseService<ProductRepository, ProductMapper, ProductDto, Product> {

    public ProductService(ProductRepository repository, ProductMapper mapper) {
        super(repository, mapper);
    }

}