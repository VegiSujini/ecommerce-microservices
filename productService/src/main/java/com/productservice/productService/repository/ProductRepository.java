package com.productservice.productService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productservice.productService.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
