package com.example.day_17_1118_blog.service;

import com.example.day_17_1118_blog.entity.User;
import com.example.day_17_1118_blog.request.LoginRequest;
import com.example.day_17_1118_blog.security.CustomUserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class AuthService {
    @Autowired
    private AuthenticationManager authenticationManager;

    public User login(LoginRequest request, HttpSession session) {
        try {
            // Tạo đối tượng để xác thực
            UsernamePasswordAuthenticationToken token =
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword());

            // Tiến hành xác thực
            Authentication authentication = authenticationManager.authenticate(token);

            // Lưu vào trong context
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Lưu vào trong session
            session.setAttribute("MY_SESSION", authentication.getName());

            CustomUserDetail userDetails = (CustomUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return userDetails.getUser();
        } catch (AuthenticationException e) {
            throw new RuntimeException("Email hoặc password không chính xác");
        }
    }

    public String logout(HttpSession session) {
        session.invalidate();

        return "logout success";
    }
}
