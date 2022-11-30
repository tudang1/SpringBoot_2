package com.example.day_17_1118_blog.controller;

import com.example.day_17_1118_blog.entity.Blog;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class WebController {
    // 1. lấy ds tất cả bai viết đã public (status = true) và sắp xếp theo tgian
    // bao gồm cả tim kiếm theo tiêu đề category name
    // /api/v1/blogs?search=java&category=backend
    @GetMapping("/blog")
    public List<Blog> getBlogs(@RequestParam(required = false,defaultValue = "") String search,
                               @RequestParam(required = false,defaultValue = "") String category){

    }

    // 2. Lấy chi tiết bài viết
    @GetMapping("/blogs/{id}/{slug}")
    public List<Blog> getBlogById(@PathVariable Integer id){

    }

}
