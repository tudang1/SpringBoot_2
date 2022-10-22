package com.example.userbackend.controller;

import com.example.userbackend.dto.UserDto;
import com.example.userbackend.request.UpdateAvatarRequest;
import com.example.userbackend.request.UpdatePasswordRequest;
import com.example.userbackend.service.FileService;
import com.example.userbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private FileService fileService;

    @GetMapping("/users")
    public List<UserDto> getUsers() {
        return userService.getUsers();
    }

    //update anhr
    @PutMapping("/users/{id}/update-avatar")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAvatar(@PathVariable Integer id, @RequestBody UpdateAvatarRequest request){
        userService.updateAvatar(id, request);
    }

    //update password
    @PutMapping("/users/{id}/update-password")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePassword(@PathVariable Integer id, @RequestBody UpdatePasswordRequest request){
        userService.updatePassword(id, request);
    }

    //queen mk
    @PostMapping("/users/{id}/forgot-password")
    public String forgotPassword(@PathVariable Integer id){
        return userService.forgotPassword(id);
    }
    //upload file
    @PostMapping("/users/{id}/files")
    public String uploadFile(@PathVariable Integer id,@ModelAttribute("file") MultipartFile file){
        return userService.uploadFile(id, file);
    }

    //xem file
    @GetMapping(value = "/users/{id}/files/{fileId}",produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] readFile(@PathVariable Integer id, @PathVariable Integer fileId){
        return userService.readFile(id,fileId);
    }
    // lấy danh sách file user
    @GetMapping("/users/{id}/file")
    public List<String> getFiles(@PathVariable Integer id){
        return userService.getFiles(id);
    }

    //xoas file
    @DeleteMapping("/users/{id}/files/{fileId}")
    public void deleteFile(@PathVariable Integer id , @PathVariable Integer fileId){
        userService.deleteFile(fileId);
    }
}
