package com.example.demouser;

import com.example.demouser.entity.User;
import com.example.demouser.repository.UserRepository;
import org.apache.tomcat.util.buf.UEncoder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoUserApplicationTests {

    @Autowired
    private UserRepository userRepository;
    @Test
    void save_user() {
        User user1 = User.builder()
                .name("Đặng Hồng Tư")
                .email("danghongtu@gmail.com")
                .phone("098721345")
                .address("Thái Bình")
                .password("111")
                .build();
        User user2 = User.builder()
                .name("Đặng Văn A")
                .email("dangvana@gmail.com")
                .phone("098444444")
                .address("Hà Nội")
                .password("222")
                .build();
        User user3 = User.builder()
                .name("Nguyễn Hương C")
                .email("nguyenhuongc@gmail.com")
                .phone("09822222")
                .address("Hải Dương")
                .password("333")
                .build();
        userRepository.saveAll(List.of(user1,user2,user3));
    }

}
