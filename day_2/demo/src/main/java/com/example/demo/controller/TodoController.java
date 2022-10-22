package com.example.demo.controller;

import com.example.demo.entity.Todo;
import com.example.demo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class TodoController {
    @Autowired
    private TodoService todoService;
    @GetMapping("/todos")
    public List<Todo> getTodos(@RequestParam Optional<Boolean> status){
        if (status.isPresent()){
            return todoService.getTodos(status.get());
        }
        return todoService.getTodos();
    }
}
