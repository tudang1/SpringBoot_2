package com.example.todolistbackend.repository;

import com.example.todolistbackend.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
    List<Todo> getTodosByStatus(Boolean status);
}