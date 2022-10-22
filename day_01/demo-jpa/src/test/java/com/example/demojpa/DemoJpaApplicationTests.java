package com.example.demojpa;

import com.example.demojpa.entity.User;
import com.example.demojpa.repository.UserRepository;
import com.github.javafaker.Faker;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

//@SpringBootTest
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DemoJpaApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Rollback(value = false)
    void save_user() {
        Faker faker = new Faker();

        for (int i = 0; i < 50; i++) {
            User user = User.builder()
                    .name(faker.name().fullName())
                    .email(faker.internet().emailAddress())
                    .age(faker.number().numberBetween(20, 70))
                    .build();

            userRepository.save(user);
        }
    }

    @Test
    void get_all_user() {
        List<User> user =  userRepository.findAll();
        System.out.println(user.size());
    }

    @Test
    void get_user_by_id() {
        Optional<User> userOptional = userRepository.findById(2);
        userOptional.ifPresent(System.out::println);
    }

    @Test
    @Rollback(value = false)
    void delete_user_by_id() {
        userRepository.deleteById(1);
    }

    @Test
    void test_getByNameContainsIgnoreCase() {
        List<User> users = userRepository.getByNameContainsIgnoreCase("Rice");
        users.forEach(System.out::println);

        Assertions.assertThat(users).isNotNull();
        Assertions.assertThat(users.size()).isEqualTo(2);
    }

    @Test
    @Rollback(value = false)
    void test_updateUserName() {
        userRepository.updateUserName(2, "Bùi Hiên");
    }

    @Test
    @Rollback(value = false)
    void test_updateUserName_other() {
        User user = userRepository.getUserById(3);

        user.setName("Nguyễn Văn A");
        userRepository.save(user);
    }

    @Test
    void test_getByOrderByAgeAsc() {
        List<User> users = userRepository.getByOrderByAgeAsc();
        users.forEach(System.out::println);
    }

    @Test
    void test_getListUserOrderByNameAsc() {
        List<User> users = userRepository.getListUserOrderByNameAsc();
        users.forEach(System.out::println);
    }

    @Test
    void test_getAllSort() {
        List<User> users = userRepository.findAll(Sort.by("age").ascending());
        users.forEach(System.out::println);
    }

    @Test
    void test_pagination() {
//        Page<User> page = userRepository.findAll(PageRequest.of(0, 10));
        Page<User> page = userRepository.findAll(PageRequest.of(0, 10, Sort.by("age").ascending()));

        page.getContent().forEach(System.out::println);
    }
}
