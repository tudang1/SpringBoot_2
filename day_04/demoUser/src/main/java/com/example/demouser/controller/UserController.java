package com.example.demouser.controller;

import com.example.demouser.dto.UserDto;
import com.example.demouser.entity.User;
import com.example.demouser.repository.UserRepository;
import com.example.demouser.request.CreateUser;
import com.example.demouser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<UserDto> getUsers() {
        return userService.getUsers();
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Integer id){
        return ResponseEntity.ok(userService.getUserById(id));
    }
    @PostMapping("/users")
    public User createUser(@RequestBody CreateUser request){
        return userService.createUser(request);
    }
    @PutMapping("/users/{id}")
    public UserDto updateUser(@PathVariable Integer id){
        return null;
    }
}
