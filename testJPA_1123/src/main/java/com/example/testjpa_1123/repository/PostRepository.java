package com.example.testjpa_1123.repository;

import com.example.testjpa_1123.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}