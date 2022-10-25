package com.example.test_springboot;

import com.example.test_springboot.entity.Course;
import com.example.test_springboot.entity.Topic;
import com.example.test_springboot.entity.User;
import com.example.test_springboot.repository.CourseRepository;
import com.example.test_springboot.repository.TopicRepository;
import com.example.test_springboot.repository.UserRepository;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootTest
class TestSpringBootApplicationTests {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Test
    void save_user() {
        Faker faker = new Faker();

        for (int i = 0; i < 10; i++) {
            User user = User.builder()
                    .name(faker.name().fullName())
                    .email(faker.internet().emailAddress())
                    .phone(faker.phoneNumber().phoneNumber())
                    .build();
            userRepository.save(user);
        }
    }
    @Test
    void save_topic(){
        Topic topic1 = Topic.builder()
                .name("Java")
                .build();
        Topic topic2 = Topic.builder()
                .name("JS")
                .build();
        Topic topic3 = Topic.builder()
                .name("Php")
                .build();
        Topic topic4 = Topic.builder()
                .name("C#")
                .build();
        topicRepository.saveAll(List.of(topic1,topic2,topic3,topic4));
    }
    @Test
    void save_course() {
        List<User> list = userRepository.findAll();
        List<Topic> topicList = topicRepository.findAll();
        Faker faker = new Faker();

        Random rd = new Random();

        for (int i = 0; i < 10; i++) {
            User rduser = list.get(rd.nextInt(list.size()));

            List<Topic> myList = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                Topic rdtopic = topicList.get(rd.nextInt(topicList.size()));
                if (!myList.contains(rdtopic)) {
                    myList.add(rdtopic);
                }
            }
            Course course = Course.builder()
                    .name(faker.company().name())
                    .description(faker.lorem().sentence(10))
                    .type(rd.nextInt(2)== 0 ? "Online" : "Onlab")
                    .user(rduser)
                    .topics(myList)
                    .build();
            courseRepository.save(course);
        }
    }


}
