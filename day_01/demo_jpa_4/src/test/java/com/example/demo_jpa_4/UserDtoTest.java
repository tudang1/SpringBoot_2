package com.example.demo_jpa_4;

import com.example.demo_jpa_4.Mapper.UserMapper;
import com.example.demo_jpa_4.dto.UserDto;
import com.example.demo_jpa_4.dto.UserInfo;
import com.example.demo_jpa_4.entity.User;
import com.example.demo_jpa_4.repository.UserRepository;
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
    void test_getUserDtoUsingCustomMapper(){
        User user = userRepository.getUserById(10);

        UserDto userDto = UserMapper.toUserDto(user);
        System.out.println(userDto);
    }
    //model MApper
    @Test
    void test_getUserDtoUsingModelMapper(){
        User user = userRepository.getUserById(20);
        ModelMapper modelMapper = new ModelMapper();
        UserDto userDto = modelMapper.map(user, UserDto.class);
        System.out.println(userDto);
    }
    @Test
    void test_getUserByEmail(){
        User user = userRepository.getUserByEmail("katherin.runolfsdottir@yahoo.com");
        UserDto userDto = UserMapper.toUserDto(user);
        System.out.println(userDto);
    }
    @Test
    void test_getUserDtoByEmail(){
        UserDto userDto = userRepository.getUserDtoByEmail("saturnina.langworth@yahoo.com");
        System.out.println(userDto);
    }
    @Test
    void test_getUserDtoEmailUsingNativeQuery(){
        UserDto userDto = userRepository.getUserDtoEmailUsingNativeQuery("saturnina.langworth@yahoo.com");
        System.out.println(userDto);
    }

}
