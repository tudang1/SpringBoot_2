package com.example.userbackend.service;

import com.example.userbackend.dto.UserDto;
import com.example.userbackend.entity.User;
import com.example.userbackend.exception.BadRequestException;
import com.example.userbackend.exception.NotFoundException;
import com.example.userbackend.repository.UserRepository;
import com.example.userbackend.request.CreateUserRequest;
import com.example.userbackend.request.UpdateAvatarRequest;
import com.example.userbackend.request.UpdatePasswordRequest;
import com.example.userbackend.request.UpdateUserRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private MailService mailService;

    @Autowired
    private FileService fileService;

    // Laays danh sách tất cả user
    public List<UserDto> getUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    // Tìm kiếm user theo tên
    public List<UserDto> searchUser(String name) {
        List<User> users = userRepository.findByNameContainsIgnoreCase(name);
        return users.stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    // Lấy thông tin của user theo id
    public UserDto getUserById(int id) {
        User user = userRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found user with id = " + id);
        });
        return modelMapper.map(user, UserDto.class);
    }

    // Xóa user
    public void deleteUser(int id) {
        User user = userRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found user with id = " + id);
        });
        userRepository.delete(user);
    }

    // Tạo user mới
    public UserDto createUser(CreateUserRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new BadRequestException("email = " + request.getEmail() + " is existed");
        }

        Random rd = new Random();
        User user = new User();
        user.setId(rd.nextInt(100));
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setAddress(request.getAddress());
        user.setPassword(request.getPassword());

        userRepository.save(user);

        return modelMapper.map(user, UserDto.class);
    }

    // Cập nhật thông tin của user
    public UserDto updateUser(int id, UpdateUserRequest request) {
        User user = userRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found user with id = " + id);
        });

        user.setName(request.getName());
        user.setPhone(request.getPhone());
        user.setAddress(request.getAddress());

        userRepository.save(user);

        return modelMapper.map(user, UserDto.class);
    }

    public void updateAvatar(Integer id, UpdateAvatarRequest request) {
        User user = userRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found user with id = " + id);
        });

//        user.setAvatar(request.getAvatar());
//        userRepository.save(user);
        userRepository.updateAvatar(id, request.getAvatar());
    }

    // Thay đổi mật khẩu
    public void updatePassword(Integer id, UpdatePasswordRequest request) {
        User user = userRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found user with id = " + id);
        });

        // Kiểm tra xem password cũ có chính xác hay không
        if(!user.getPassword().equals(request.getOldPassword())) {
            throw new BadRequestException("Mật khẩu cũ không chính xác");
        }

        // Kiểm tra xem password cũ và mới có trùng nhau hay không
        if(request.getOldPassword().equals(request.getNewPassword())) {
            throw new BadRequestException("Mật khẩu cũ và mới không được trùng nhau");
        }

        user.setPassword(request.getNewPassword());
        userRepository.save(user);
    }

    public String forgotPassword(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found user with id = " + id);
        });

        // Generate password
        String newPassword = UUID.randomUUID().toString();

        user.setPassword(newPassword);
        userRepository.save(user);

        // Send mail
        mailService.sendMail(user.getEmail(), "Quên mật khẩu", "Mật khẩu mới : " + newPassword);

        return newPassword;
    }

    public String uploadFile(Integer id, MultipartFile file) {
        User user = userRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found user with id = " + id);
        });

        return fileService.uploadFile(user, file);
    }

    public byte[] readFile(Integer id, Integer fileId) {
        User user = userRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found user with id = " + id);
        });
        return fileService.readFile(fileId);
    }

    public List<String> getFiles(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found user with id = " + id);
        });
        return fileService.getFiles(id);
    }

    public void deleteFile(Integer id, Integer fileId) {
        User user = userRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found user with id = " + id);
        });
        fileService.deleteFile(fileId);
    }
}
