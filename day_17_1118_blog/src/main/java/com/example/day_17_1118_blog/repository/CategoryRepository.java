package com.example.day_17_1118_blog.repository;

import com.example.day_17_1118_blog.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}