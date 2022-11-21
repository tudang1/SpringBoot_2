package com.example.day_17_1118_blog.repository;

import com.example.day_17_1118_blog.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
}