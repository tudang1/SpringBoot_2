package com.example.day_17_1118_blog;

import com.example.day_17_1118_blog.entity.Blog;
import com.example.day_17_1118_blog.entity.Category;
import com.example.day_17_1118_blog.entity.Comment;
import com.example.day_17_1118_blog.entity.User;
import com.example.day_17_1118_blog.repository.*;
import com.github.javafaker.Faker;
import com.github.slugify.Slugify;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

@SpringBootTest
public class InitDataTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private Faker faker;

    @Autowired
    private Slugify slugify;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void save_user() {
        // Tạo user role admin
        for (int i = 0; i < 3; i++) {
            User user = User.builder()
                    .name(faker.name().fullName())
                    .email(faker.internet().emailAddress())
                    .password(passwordEncoder.encode("111"))
                    .roles(List.of("USER", "ADMIN"))
                    .build();
            userRepository.save(user);
        }

        // Tạo user bình thường
        for (int i = 0; i < 10; i++) {
            User user = User.builder()
                    .name(faker.name().fullName())
                    .email(faker.internet().emailAddress())
                    .password(passwordEncoder.encode("111"))
                    .roles(List.of("USER"))
                    .build();
            userRepository.save(user);
        }
    }

    @Test
    void save_category() {
        for (int i = 0; i < 5; i++) {
            Category category = Category.builder()
                    .name(faker.leagueOfLegends().champion())
                    .build();
            categoryRepository.save(category);
        }
    }

    @Test
    void save_blog() {
        Random rd = new Random();

        List<User> users = userRepository.findAll();
        List<User> usersHasRoleAdmin = users.stream()
                .filter(user -> user.getRoles().contains("ADMIN"))
                .collect(Collectors.toList());

        List<Category> categories = categoryRepository.findAll();

        for (int i = 0; i < 30; i++) {
            // Random 1 user
            User rdUser = usersHasRoleAdmin.get(rd.nextInt(usersHasRoleAdmin.size()));

            // Random 1 ds category
            Set<Category> rdListCategory = new HashSet<>();
            for (int j = 0; j < 3; j++) {
                Category rdCategory = categories.get(rd.nextInt(categories.size()));
                rdListCategory.add(rdCategory);
            }

            // Tạo blog
            String title = faker.lorem().sentence(10);
            Blog blog = Blog.builder()
                    .title(title)
                    .slug(slugify.slugify(title))
                    .description(faker.lorem().sentence(30))
                    .content(faker.lorem().sentence(100))
                    .status(rd.nextInt(2) == 1)
                    .user(rdUser)
                    .categories(rdListCategory)
                    .build();

            blogRepository.save(blog);
        }
    }

    @Test
    void save_comment() {
        Random rd = new Random();

        List<User> users = userRepository.findAll();
        List<Blog> blogs = blogRepository.findAll();

        for (int i = 0; i < 100; i++) {
            // Random 1 user
            User rdUser = users.get(rd.nextInt(users.size()));

            // Random 1 blog
            Blog rdBlog = blogs.get(rd.nextInt(blogs.size()));

            Comment comment = Comment.builder()
                    .content(faker.lorem().sentence(10))
                    .user(rdUser)
                    .blog(rdBlog)
                    .build();

            commentRepository.save(comment);
        }
    }
}
