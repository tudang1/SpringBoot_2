package com.example.day_17_1118_blog.repository;

import com.example.day_17_1118_blog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}