package com.example.day_17_1118_blog.repository;

import com.example.day_17_1118_blog.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Integer> {
}