package com.example.demo_jpa_4;

import com.example.demo_jpa_4.entity.User;
import com.example.demo_jpa_4.repository.UserRepository;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class DemoJpa4ApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    void save_user() {
        Faker faker = new Faker();
        for (int i = 0; i<50;i++){
            User user = User.builder()
                    .name(faker.name().fullName())
                    .email(faker.internet().emailAddress())
                    .age(faker.number().numberBetween(20,70))
                    .build();
            userRepository.save(user);
        }
    }
    @Test
    void get_all_user(){
        List<User> user = userRepository.findAll();
        System.out.println(user.size());
    }
    @Test
    void get_user_by_id(){
        Optional<User> userOptional = userRepository.findById(2);
        userOptional.ifPresent(System.out::println);
    }
    @Test
    void delete_user_by_id(){
        userRepository.deleteById(1);
    }

    @Test
    void test_getByNameContiansIgnoreCase(){
        List<User> users = userRepository.getByNameContainsIgnoreCase("Huel");
        users.forEach(System.out::println);
    }

    @Test
    void test_updateUserName(){
        userRepository.updateUserName(2,"tu");
    }

    @Test
    void test_updateUserNameOther(){
        User user = userRepository.getUserById(3);

        user.setName("Dang Hong Tu");
        userRepository.save(user);
    }
    @Test
    void test_getByOrderByAgeAsc(){
        List<User> user = userRepository.getByOrderByAgeAsc();
        user.forEach(System.out::println);
    }

    @Test
    void test_pagination(){
        Page<User> page =  userRepository.findAll(PageRequest.of(0,10, Sort.by("age").ascending()));
        System.out.println(page.getContent());
    }

}
