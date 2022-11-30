package com.example.todolistbackend.service;

import com.example.todolistbackend.entity.Todo;
import com.example.todolistbackend.exception.BadRequestException;
import com.example.todolistbackend.exception.NotFoundException;
import com.example.todolistbackend.repository.TodoRepository;
import com.example.todolistbackend.request.CreateTodoRequest;
import com.example.todolistbackend.request.UpdateTodoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }

    public List<Todo> getTodos(Boolean status) {
        return todoRepository.getTodosByStatus(status);
    }

    public Todo getTodoById(Integer id) {
        Optional<Todo> todoOptional = todoRepository.findById(id);
        if(todoOptional.isPresent()) {
            return todoOptional.get();
        }
        throw new NotFoundException("Not found todo with id = " + id);
    }

    public Todo createTodo(CreateTodoRequest request) {
        if(request.getTitle().isEmpty()) {
            throw new BadRequestException("Tiêu đề không được để trống");
        }

        Todo todo = Todo.builder()
                .title(request.getTitle())
                .build();

        return todoRepository.save(todo);
    }

    public Todo updateTodo(Integer id, UpdateTodoRequest request) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found todo with id = " + id);
        });

        todo.setTitle(request.getTitle());
        todo.setStatus(request.getStatus());

        return todoRepository.save(todo);
    }

    public void deleteTodo(Integer id) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found todo with id = " + id);
        });
        todoRepository.delete(todo);
    }
}
