package com.example.testjpa_1123.repository;

import com.example.testjpa_1123.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}