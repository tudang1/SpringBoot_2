package com.example.userbackend;

import com.example.userbackend.entity.User;
import com.example.userbackend.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserBackendApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Rollback(value = false)
    void save_user() {
        User user = User.builder()
                .name("Nguyễn Văn A")
                .email("a@gmail.com")
                .phone("0988887777")
                .address("Thành phố Hà Nội")
                .password("111")
                .build();

        User user1 = User.builder()
                .name("Trần Văn B")
                .email("b@gmail.com")
                .phone("0988886666")
                .address("Thành phố Hải Phòng")
                .password("111")
                .build();

        User user2 = User.builder()
                .name("Ngô Thị C")
                .email("c@gmail.com")
                .phone("0988885555")
                .address("Thành phố Hồ Chí Minh")
                .password("111")
                .build();

        userRepository.saveAll(List.of(user, user1, user2));
    }

}
