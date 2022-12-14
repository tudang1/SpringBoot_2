package com.example.day_17_1118_blog.controller;

import com.example.day_17_1118_blog.request.LoginRequest;
import com.example.day_17_1118_blog.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("api")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("login")
    public String login(@RequestBody LoginRequest loginRequest, HttpSession session){
        return authService.login(loginRequest,session);
    }
    @GetMapping("handle-logout")
    public String logout(HttpSession session) {
        return authService.logout(session);
    }
}
