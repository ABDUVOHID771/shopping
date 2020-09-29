package com.example.shoppingapp.dao.repository;

import com.example.shoppingapp.dao.domain.ProductCategory;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "productCategory", path = "product-category")
public interface ProductCategoryRepository extends BaseRepository<ProductCategory> {
}
