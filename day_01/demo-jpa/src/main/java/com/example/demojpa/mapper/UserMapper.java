package com.example.demojpa.mapper;

import com.example.demojpa.dto.UserDto;
import com.example.demojpa.entity.User;

public class UserMapper {
    public static UserDto toUserDto(User user) {
        return new UserDto(user.getId(), user.getName(), user.getEmail());
    }
}
