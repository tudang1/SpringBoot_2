package com.example.day_17_1118_blog.controller;

import com.example.day_17_1118_blog.entity.Blog;
import com.example.day_17_1118_blog.request.CreateBlogRequest;
import com.example.day_17_1118_blog.request.UpdateBlogRequest;
import com.example.day_17_1118_blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("blog")
    public List<Blog> getBlogs(){
        return blogService.getBlogs();
    }

    //2. lấy chi tiết blog
    @GetMapping("blog/{id}")
    public Blog getBlogById(@PathVariable Integer id){
        return blogService.getBlogById(id);
    }

    // 3. tạo blog
    @PostMapping("blogs")
    public Blog createBlog(@RequestBody CreateBlogRequest request){
        return blogService.createBlog(request);
    }

    //4.cập nhập Blog
    @PostMapping("blogs/{id}")
    public Blog craeteBlog(@PathVariable Integer id, @RequestBody UpdateBlogRequest request){
        return blogService.updateBlog(id,request);
    }

    //5. xóa Blog
    @DeleteMapping("blog/{id}")
    public void deleteBlogById(@PathVariable Integer id){
        blogService.deleteBlogById(id);
    }

}
