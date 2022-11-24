package com.example.testjpa_1123.repository;

import com.example.testjpa_1123.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}