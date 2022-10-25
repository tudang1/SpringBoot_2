package com.example.test_springboot.repository;

import com.example.test_springboot.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Integer> {
    List<Course> findByType(String type);

    List<Course> findByNameContains(String name);

    List<Course> findByNameAndTopics(String name, String topics);

}
