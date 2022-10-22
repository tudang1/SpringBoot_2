package com.example.userbackend.service;

import com.example.userbackend.dto.UserDto;
import com.example.userbackend.entity.User;
import com.example.userbackend.exception.BadRequestException;
import com.example.userbackend.exception.NotFoundException;
import com.example.userbackend.repository.UserRepository;
import com.example.userbackend.request.UpdateAvatarRequest;
import com.example.userbackend.request.UpdatePasswordRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MailService mailService;

    @Autowired
    private FileService fileService;

    @Autowired
    private ModelMapper modelMapper;

    public List<UserDto> getUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    public void updateAvatar(Integer id, UpdateAvatarRequest request) {
        User user = userRepository.findById(id).orElseThrow(() ->{
            throw new NotFoundException("Not found user with by id = "+ id);
        });

        user.setAvatar(request.getAvatar());
        userRepository.save(user);
    }


    public void updatePassword(Integer id, UpdatePasswordRequest request) {
        User user = userRepository.findById(id).orElseThrow(()->{
            throw new NotFoundException("Not found user with by id = "+ id);
        });

        //kiem tra oldPassword chinh xac k?
        if (!user.getPassword().equals(request.getOldPassword())){
            throw new BadRequestException("mật khẩu cũ k chính xác");
        }

        //kiểm tra new password cũ và mới có trùng nhau hay k?
        if (request.getOldPassword().equals(request.getNewPassword())){
            throw new BadRequestException("Mật khẩu mới k đc trùng với mk cũ");
        }

        user.setPassword(request.getNewPassword());
        userRepository.save(user);
    }

    public String forgotPassword(Integer id) {
        User user = userRepository.findById(id).orElseThrow(()->{
            throw new NotFoundException("Not found user with by id = "+ id);
        });
        //generate password
        String newPassword = UUID.randomUUID().toString();

        user.setPassword(newPassword);
        userRepository.save(user);

        //send mail
        mailService.sendMail(user.getEmail(),"Quen mk","mk moi = "+ newPassword);

        return newPassword;
    }

    public String uploadFile(Integer id, MultipartFile file) {
        User user = userRepository.findById(id).orElseThrow(()->{
            throw new NotFoundException("Not found user with by id = "+ id);
        });
        return fileService.uploadFile(user , file);
    }

    public byte[] readFile(Integer id, Integer fileId) {
        User user = userRepository.findById(id).orElseThrow(()->{
            throw new NotFoundException("Not found user with by id = "+ id);
        });
        return fileService.readFile(fileId);
    }

    public List<String> getFiles(Integer id) {
        return null;
    }

    public void deleteFile(Integer fileId) {
    }
}
