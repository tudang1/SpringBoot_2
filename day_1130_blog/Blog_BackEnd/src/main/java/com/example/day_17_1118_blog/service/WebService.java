package com.example.day_17_1118_blog.service;

import com.example.day_17_1118_blog.entity.Blog;
import com.example.day_17_1118_blog.entity.Category;
import com.example.day_17_1118_blog.exception.BadRequestException;
import com.example.day_17_1118_blog.exception.NotFoundException;
import com.example.day_17_1118_blog.repository.BlogRepository;
import com.example.day_17_1118_blog.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class WebService {
    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Blog> getBlogs(String search, String category) {
        log.info("search {}", search);
        log.info("category {}", category);
        return blogRepository.findByTitleContainsIgnoreCaseAndStatusTrueAndCategories_NameIgnoreCaseOrderByPublishedAtDesc(search, category);
    }

    public Blog getBlogById(Integer id) {
        // trả vè thông tin bài viết public
        //nếu bài viết tồn tại mà status = false => báo lỗi
        Blog blog = blogRepository.findById(id).orElseThrow(()->{
            throw new NotFoundException("Not found blod with Id = " + id);
        });
        if (!blog.getStatus()){
            throw new BadRequestException("Fail");
        }
        return blog;
    }

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }
}
