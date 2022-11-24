package com.example.testjpa_1123.repository;

import com.example.testjpa_1123.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}