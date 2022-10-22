package com.example.demo_jpa_4.Mapper;

import com.example.demo_jpa_4.dto.UserDto;
import com.example.demo_jpa_4.entity.User;

public class UserMapper {
    public static UserDto toUserDto(User user){
        return new UserDto(user.getId(), user.getName(), user.getEmail());
    }
}
