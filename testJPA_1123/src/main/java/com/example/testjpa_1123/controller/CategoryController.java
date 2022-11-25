package com.example.testjpa_1123.controller;

import com.example.testjpa_1123.entity.Category;
import com.example.testjpa_1123.repository.CategoryRepository;
import com.example.testjpa_1123.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("categories")
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    @GetMapping("categories/{id}")
    public Category getCateboryById(@PathVariable Long id){
        return categoryRepository.findById(id).orElseThrow(()->{
            throw new RuntimeException("Not found Category with id = "+ id);
        });
    }

    @DeleteMapping("categories/{id}")
    public void deleteCategoryById(@PathVariable Long id){
        Category category = categoryRepository.findById(id).orElseThrow(()->{
            throw new RuntimeException("Not found Category with id = "+ id);
        });

        categoryRepository.delete(category);
    }
}
