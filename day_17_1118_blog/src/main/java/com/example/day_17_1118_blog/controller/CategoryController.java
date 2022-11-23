package com.example.day_17_1118_blog.controller;

import com.example.day_17_1118_blog.entity.Category;
import com.example.day_17_1118_blog.request.UpsertCategory;
import com.example.day_17_1118_blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    //1 lấy danh sách
    @GetMapping("categories")
    public List<Category> getCategories(){
        return categoryService.getCategories();
    }

    //2. lấy chi tiết Category theo id
    @GetMapping("categories/{id}")
    public Category getCategoryById(@PathVariable Integer id){
        return categoryService.getCategoryById(id);
    }

    //3. tao mới
    @PostMapping("category")
    public Category createCategory(@RequestBody UpsertCategory request){
        return categoryService.createCategory(request);
    }

    //4. cập nhập
    @PutMapping("categories/{id}")
    public Category updateCategory(@RequestBody UpsertCategory request, @PathVariable Integer id){
        return categoryService.updateCategory(id,request);
    }

    //5. xóa
    @DeleteMapping("categories/{id}")
    public void deleteCategory(@PathVariable Integer id){
        categoryService.deleteCategory(id);
    }

}
