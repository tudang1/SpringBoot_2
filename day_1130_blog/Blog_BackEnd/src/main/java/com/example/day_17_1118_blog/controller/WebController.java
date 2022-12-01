package com.example.day_17_1118_blog.controller;

import com.example.day_17_1118_blog.entity.Blog;
import com.example.day_17_1118_blog.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class WebController {
    @Autowired
    private WebService webService;
    // 1. lấy ds tất cả bai viết đã public (status = true) và sắp xếp theo tgian
    // bao gồm cả tim kiếm theo tiêu đề category name
    // /api/v1/blogs?search=java&category=backend
    @GetMapping("/blog")
    public List<Blog> getBlogs(@RequestParam(required = false) String search,
                               @RequestParam(required = false) String category){
        return webService.getBlogs(search,category);
    }

    // 2. Lấy chi tiết bài viết
    @GetMapping("/blogs/{id}/{slug}")
    public Blog getBlogById(@PathVariable Integer id){
        return webService.getBlogById(id);
    }

}
