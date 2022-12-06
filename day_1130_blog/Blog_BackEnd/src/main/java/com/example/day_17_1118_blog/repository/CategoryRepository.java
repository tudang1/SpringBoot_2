package com.example.day_17_1118_blog.repository;

import com.example.day_17_1118_blog.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Set<Category> findByIdIn(Set<Integer> ids);

    Optional<Category> findByName(String name);

    long countByNameIgnoreCase(String name);
}