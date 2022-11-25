package com.example.testjpa_1123.repository;

import com.example.testjpa_1123.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByNameContainsIgnoreCase(String name);
}