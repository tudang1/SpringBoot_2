package com.example.demouser.service;

import com.example.demouser.dto.UserDto;
import com.example.demouser.entity.User;
import com.example.demouser.exception.NotFoundException;
import com.example.demouser.repository.UserRepository;
import com.example.demouser.request.CreateUser;
import com.example.demouser.request.UpdateUser;
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

    public List<UserDto> getUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    public UserDto getUserById(Integer id){
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()){
            return modelMapper.map(userOptional.get(),UserDto.class);
        }
        throw new NotFoundException("Not found user with id = "+ id);
    }

    public User createUser(CreateUser request){
       User user = User.builder()
               .name(request.getName())
               .email(request.getEmail())
               .phone(request.getPhone())
               .address(request.getAddress())
               .password(request.getPassword())
               .build();
       return userRepository.save(user);
    }

    public UserDto updateUser(Integer id, UpdateUser request){
        User user = userRepository.findById(id).orElseThrow(() ->{
            throw new NotFoundException("Not found user with by id = " + id);
        });

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setAddress(request.getAddress());
        user.setPassword(request.getPassword());
        userRepository.save(user);
        return modelMapper.map(user.getClass(),UserDto.class);
    }


}
