package com.example.day_17_1118_blog.service;

import com.example.day_17_1118_blog.entity.Category;
import com.example.day_17_1118_blog.exception.BadRequestException;
import com.example.day_17_1118_blog.exception.NotFoundException;
import com.example.day_17_1118_blog.repository.CategoryRepository;
import com.example.day_17_1118_blog.request.UpsertCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Integer id) {
        return categoryRepository.findById(id).orElseThrow(()->{
            throw new NotFoundException("Not found Category with id = " + id);
        });
    }

    public Category createCategory(UpsertCategory request) {
        Category category = categoryRepository.findByName(request.getName());

        if (category == null){
            Category newCategory = Category.builder()
                    .name(request.getName())
                    .build();
            return categoryRepository.save(newCategory);
        }

        throw new BadRequestException("Category đã tồn tại");
    }

    public Category updateCategory(Integer id, UpsertCategory request) {
        Category category = categoryRepository.findById(id).orElseThrow(()->{
            throw new NotFoundException("Not found Category with id = " + id);
        });

        category.setName(request.getName());

        return categoryRepository.save(category);
    }

    public void deleteCategory(Integer id) {
        Category category = categoryRepository.findById(id).orElseThrow(()->{
            throw new NotFoundException("Not found Category with id = " + id);
        });
        categoryRepository.delete(category);
    }
}
