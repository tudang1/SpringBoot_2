package com.example.demouser_4.controller;

import com.example.demouser_4.dto.UserDto;
import com.example.demouser_4.repository.UserRepository;
import com.example.demouser_4.request.CreateUser;
import com.example.demouser_4.request.UpdateInfoUser;
import com.example.demouser_4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<UserDto> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/users/{id}")
    public UserDto getUserById(@PathVariable Integer id){
        return userService.getUserById(id);
    }

    @PostMapping("/users")
    public UserDto createUser(@RequestBody CreateUser request){
        return userService.createUser(request);
    }

    @PutMapping("/users/{id}/update-info")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateUser(@PathVariable Integer id,@RequestBody UpdateInfoUser request){
         userService.updateInfoUser(id,request);
    }

    @DeleteMapping("/users/{id}")
    public void deleteById(@PathVariable Integer id){
        userService.deleteById(id);
    }
}
