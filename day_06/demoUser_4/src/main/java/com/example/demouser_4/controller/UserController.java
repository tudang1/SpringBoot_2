package com.example.demouser_4.controller;

import com.example.demouser_4.dto.UserDto;
import com.example.demouser_4.repository.UserRepository;
import com.example.demouser_4.request.CreateUser;
import com.example.demouser_4.request.UpdateAvatarRequest;
import com.example.demouser_4.request.UpdateInfoUser;
import com.example.demouser_4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
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
    public UserDto getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @PostMapping("/users")
    public UserDto createUser(@RequestBody CreateUser request) {
        return userService.createUser(request);
    }

    @PutMapping("/users/{id}/update-info")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateUser(@PathVariable Integer id, @RequestBody UpdateInfoUser request) {
        userService.updateInfoUser(id, request);
    }

    @DeleteMapping("/users/{id}")
    public void deleteById(@PathVariable Integer id) {
        userService.deleteById(id);
    }

    //update avatar
    @PutMapping("/users/{id}/update-avatar")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAvatar(@PathVariable Integer id, @RequestBody UpdateAvatarRequest request) {
        userService.updateAvatar(id, request);
    }

    //Quen mk
    @PostMapping("/users/{id}/forgot-password")
    public String forgotPassword(@PathVariable Integer id) {
        return userService.forgorPassword(id);
    }

    //uploadFile
    @PostMapping("/users/{id}/files")
    public String uploadFile(@PathVariable Integer id, @ModelAttribute("file") MultipartFile file) {
        return userService.uploadFile(id, file);
    }

    //xem file
    @GetMapping(value = "/users/{id}/files/{fileId}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] readFile(@PathVariable Integer id, @PathVariable Integer fileId) {
        return userService.readFile(id, fileId);
    }

    // lấy danh sách file user
    @GetMapping("/users/{id}/file")
    public List<String> getFiles(@PathVariable Integer id) {
        return userService.getFiles(id);
    }

    //xoas file
    @DeleteMapping("/users/{id}/files/{fileId}")
    public void deleteFile(@PathVariable Integer id, @PathVariable Integer fileId) {
        userService.deleteFile(fileId);
    }

}
