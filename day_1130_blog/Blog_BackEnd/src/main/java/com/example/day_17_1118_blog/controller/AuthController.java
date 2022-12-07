package com.example.day_17_1118_blog.controller;

import com.example.day_17_1118_blog.entity.User;
import com.example.day_17_1118_blog.request.LoginRequest;
import com.example.day_17_1118_blog.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("handle-login")
    public User login(@RequestBody LoginRequest request, HttpSession session) {
        return authService.login(request, session);
    }

    @GetMapping("handle-logout")
    public void logout(HttpSession session) {
        authService.logout(session);
    }
}
