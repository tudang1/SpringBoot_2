package com.example.day_17_1118_blog.controller;

import com.example.day_17_1118_blog.entity.User;
import com.example.day_17_1118_blog.request.UpsertUser;
import com.example.day_17_1118_blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/admin")
public class UserController {
    @Autowired
    private UserService userService;

    //1.Lấy danh sách User
    @GetMapping("users")
    public List<User> users(){
        return userService.getUsers();
    }

    //2. lấy chi tiết user by email
    @GetMapping("users/{email}")
    public Optional<User> getUserByEmail(@PathVariable String email){
        return userService.getUserByEmail(email);
    }

    //3. tạo mới
    @PostMapping("users")
    public User createUser(@RequestBody UpsertUser request){
        return userService.createUser(request);
    }
    //4. cập nhật
    @PutMapping("users/{id}")
    public User updateUser(@PathVariable Integer id, @RequestBody UpsertUser request){
        return userService.updateUser(id,request);
    }

    //5.xóa
    @DeleteMapping("users/{id}")
    public void deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
    }
}
