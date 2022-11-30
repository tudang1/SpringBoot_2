package com.example.day_17_1118_blog.service;

import com.example.day_17_1118_blog.entity.User;
import com.example.day_17_1118_blog.repository.UserRepository;
import com.example.day_17_1118_blog.request.UpsertUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User createUser(UpsertUser request) {
        return null;
    }

    public User updateUser(Integer id, UpsertUser request) {
        return null;
    }

    public void deleteUser(Integer id) {
    }


}
