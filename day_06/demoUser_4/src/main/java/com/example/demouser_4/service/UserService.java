package com.example.demouser_4.service;

import com.example.demouser_4.dto.UserDto;
import com.example.demouser_4.entity.User;
import com.example.demouser_4.exception.BadRequestException;
import com.example.demouser_4.exception.NotFoundException;
import com.example.demouser_4.repository.UserRepository;
import com.example.demouser_4.request.CreateUser;
import com.example.demouser_4.request.UpdateInfoUser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<UserDto> getUsers(){
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> modelMapper.map(user,UserDto.class))
                .collect(Collectors.toList());
    }

    public UserDto getUserById(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()){
            return modelMapper.map(userOptional.get(),UserDto.class);
        }
        throw new NotFoundException("Not found user with id = " +id );

    }

    public UserDto createUser(CreateUser request) {
        List<User> check = userRepository.findByEmail(request.getEmail());
        if (check.isEmpty()){
            User user = User.builder()
                    .name(request.getName())
                    .email(request.getEmail())
                    .phone(request.getPhone())
                    .address(request.getAddress())
                    .password(request.getPassword())
                    .build();
            userRepository.save(user);
            return modelMapper.map(user,UserDto.class);
        }
        throw new BadRequestException("Email đã tồn tại");
    }

    public void updateInfoUser(Integer id, UpdateInfoUser request) {
        User user = userRepository.findById(id).orElseThrow(()->{
            throw new NotFoundException("Not found user with id = "+id);
        });
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setAddress(request.getAddress());
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

        throw new RuntimeException("cập nhập thành công");
    }

    public void deleteById(Integer id) {
        User user = userRepository.findById(id).orElseThrow(()->{
            throw new NotFoundException("Not found user with id = "+id);
        });
        userRepository.deleteById(id);
        throw new RuntimeException("Xóa Thành Công");
    }
}
