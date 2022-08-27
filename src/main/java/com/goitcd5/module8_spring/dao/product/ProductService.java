package com.goitcd5.module8_spring.dao.product;


import java.util.List;
import java.util.UUID;

public interface ProductService {
    void saveProduct(Product product);

    void deleteProduct(UUID id);

    List<Product> findAll();

    Product findById(UUID id);
}
