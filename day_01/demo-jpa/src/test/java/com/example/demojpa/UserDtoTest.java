package com.example.demojpa;

import com.example.demojpa.dto.UserDto;
import com.example.demojpa.dto.UserInfo;
import com.example.demojpa.entity.User;
import com.example.demojpa.mapper.UserMapper;
import com.example.demojpa.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserDtoTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void test_getUserDtoUsingCustomMapper() {
        User user = userRepository.getUserById(10);

        UserDto userDto = UserMapper.toUserDto(user);
        System.out.println(userDto);
    }

    @Test
    void test_getUserDtoUsingModelMapper() {
        User user = userRepository.getUserById(10);

        ModelMapper modelMapper = new ModelMapper();
        UserDto userDto = modelMapper.map(user, UserDto.class);
        System.out.println(userDto);
    }

    @Test
    void test_getUserByEmail() {
        User user = userRepository.getUserByEmail("tiera.kilback@yahoo.com");
        System.out.println(user);
    }

    @Test
    void test_getUserDtoByEmail() {
        UserDto userDto = userRepository.getUserDtoByEmail("tiera.kilback@yahoo.com");
        System.out.println(userDto);
    }

    @Test
    void test_getUserInfoByEmail() {
        UserInfo userInfo = userRepository.getUserInfoByEmail("tiera.kilback@yahoo.com");
        System.out.println(userInfo.getId() + " - " + userInfo.getName() + " - " + userInfo.getEmail());
    }

    @Test
    void test_getUserDtoByEmailUsingNativeQuery() {
        UserDto userDto = userRepository.getUserDtoByEmailUsingNativeQuery("tiera.kilback@yahoo.com");
        System.out.println(userDto);
    }
}
