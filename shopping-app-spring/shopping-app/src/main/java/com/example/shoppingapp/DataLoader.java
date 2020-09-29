package com.example.shoppingapp;

import com.example.shoppingapp.dao.domain.Product;
import com.example.shoppingapp.dao.domain.ProductCategory;
import com.example.shoppingapp.mapper.ProductCategoryMapper;
import com.example.shoppingapp.mapper.ProductMapper;
import com.example.shoppingapp.service.ProductCategoryService;
import com.example.shoppingapp.service.ProductService;
import javassist.NotFoundException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DataLoader implements CommandLineRunner {

    private final ProductService productService;
    private final ProductMapper productMapper;
    private final ProductCategoryService productCategoryService;
    private final ProductCategoryMapper productCategoryMapper;

    public DataLoader(ProductService productService, ProductMapper productMapper, ProductCategoryService productCategoryService, ProductCategoryMapper productCategoryMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
        this.productCategoryService = productCategoryService;
        this.productCategoryMapper = productCategoryMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        loader();
    }

    public void loader() throws NotFoundException {

        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("Book");
        ProductCategory createdProductCategory = productCategoryService.create(productCategory);

        for (int i = 0; i < 10; i++) {
            Product product = new Product();
            product.setName("Product " + i);
            product.setSku("INFO 10556 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'\n");
            product.setUnitsInStock(i);
            product.setUnitPrice(BigDecimal.valueOf(10000 + i));
            product.setActive(true);
            product.setImageUrl("/assets/images/products/book/image_book.jpg");
            product.setCategory(productCategory);
            product.setDescription("INFO 10556 --- [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'\n" +
                    "INFO 10556 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'\n" +
                    "INFO 10556 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'\n" +
                    "INFO 10556 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'\n" +
                    "INFO 10556 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''\n");
            productCategory.getProducts().add(product);
            productCategory.setId(createdProductCategory.getId());
        }
        productCategoryService.create(productCategory);

        ProductCategory productCategory1 = new ProductCategory();
        productCategory1.setCategoryName("Jack ");
        ProductCategory created = productCategoryService.create(productCategory1);

        for (int j = 0; j < 10; j++) {
            Product product = new Product();
            product.setName("Jack " + j);
            product.setSku("INFO 10556 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'\n");
            product.setUnitsInStock(j + 1);
            product.setUnitPrice(BigDecimal.valueOf(200000 + j));
            product.setActive(true);
            product.setImageUrl("/assets/images/products/coffee/image_coffee.jpg");
            product.setCategory(productCategory1);
            product.setDescription("INFO 10556 --- [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'\n" +
                    "INFO 10556 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'\n" +
                    "INFO 10556 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'\n" +
                    "INFO 10556 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'\n" +
                    "INFO 10556 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''\n");
            productCategory1.getProducts().add(product);
            productCategory1.setId(created.getId());
        }
        productCategoryService.create(productCategory1);

    }
}
