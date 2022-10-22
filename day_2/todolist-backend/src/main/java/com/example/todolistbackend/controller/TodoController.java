package com.example.todolistbackend.controller;

import com.example.todolistbackend.entity.Todo;
import com.example.todolistbackend.exception.BadRequestException;
import com.example.todolistbackend.exception.ErrorMessage;
import com.example.todolistbackend.repository.TodoRepository;
import com.example.todolistbackend.request.CreateTodo;
import com.example.todolistbackend.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @Autowired
    private TodoRepository todoRepository;
    @GetMapping("/todos")
    public List<Todo> getTodos(@RequestParam Optional<Boolean> status) {
        if(status.isPresent()) {
            return todoService.getTodos(status.get());
        }
        return todoService.getTodos();
    }

//    @GetMapping("/todos/{id}")
//    public ResponseEntity<?> getTodoById(@PathVariable Integer id) {
//        try {
//            return ResponseEntity.ok(todoService.getTodoById(id));
//        } catch (RuntimeException e) {
//            return new ResponseEntity<>(
//                    new ErrorMessage(HttpStatus.NOT_FOUND, e.getMessage()),
//                    HttpStatus.NOT_FOUND
//            );
//        }
//    }
    @GetMapping("/todos/{id}")
    public ResponseEntity<?> getTodoById(@PathVariable Integer id){
        return ResponseEntity.ok(todoService.getTodoById(id));
    }
    @PostMapping("/todos")
   public Todo createTodo(@RequestBody CreateTodo request){
        return todoService.createTodo(request);
    }


}
