package com.example.day_17_1118_blog.service;

import com.example.day_17_1118_blog.entity.Blog;
import com.example.day_17_1118_blog.entity.Category;
import com.example.day_17_1118_blog.entity.User;
import com.example.day_17_1118_blog.exception.NotFoundException;
import com.example.day_17_1118_blog.repository.BlogRepository;
import com.example.day_17_1118_blog.repository.CategoryRepository;
import com.example.day_17_1118_blog.repository.UserRepository;
import com.example.day_17_1118_blog.request.UpsertBlogRequest;
import com.github.slugify.Slugify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Slugify slugify;

    // 1. Lấy danh sách blog
    public List<Blog> getBlogs() {
        return blogRepository.findAll();
    }

    // 2. Lấy chi tiết blog theo id
    public Blog getBlogById(Integer id) {
        return blogRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found blog with id = " + id);
        });
    }

    // 3. Tạo blog mới
    public Blog createBlog(UpsertBlogRequest request) {
        // Lấy ra ds category tương ứng (từ ds id gửi lên)
        Set<Category> categories = categoryRepository.findByIdIn(request.getCategoryIds());

        // Lấy ra ai là người tạo bài viết này --> chính là user đang login
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();

        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> {
            throw new NotFoundException("Not found user with email = " + userEmail);
        });

        // Tạo bài viết
        Blog blog = Blog.builder()
                .title(request.getTitle())
                .slug(slugify.slugify(request.getTitle()))
                .content(request.getContent())
                .description(request.getDescription())
                .thumbnail(request.getThumbnail())
                .status(request.getStatus())
                .user(user)
                .categories(categories)
                .build();

        // Trả về bài viết sau khi tạo
        return blogRepository.save(blog);
    }

    // 4. Cập nhật thông tin blog
    public Blog updateBlog(Integer id, UpsertBlogRequest request) {
        Blog blog = blogRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found blog with id = " + id);
        });

        // Lấy ra ds category tương ứng (từ ds id gửi lên)
        Set<Category> categories = categoryRepository.findByIdIn(request.getCategoryIds());

        blog.setTitle(request.getTitle());
        blog.setSlug(slugify.slugify(request.getTitle()));
        blog.setContent(request.getContent());
        blog.setDescription(request.getDescription());
        blog.setThumbnail(request.getThumbnail());
        blog.setStatus(request.getStatus());
        blog.setCategories(categories);

        return blogRepository.save(blog);
    }

    // 5. Xóa blog
    public void deleteBlogById(Integer id) {
        Blog blog = blogRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found blog with id = " + id);
        });
        blogRepository.delete(blog);
    }
}