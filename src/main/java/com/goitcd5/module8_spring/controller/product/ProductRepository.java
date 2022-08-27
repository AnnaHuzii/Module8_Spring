package com.goitcd5.module8_spring.controller.product;

import com.goitcd5.module8_spring.dao.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

}
