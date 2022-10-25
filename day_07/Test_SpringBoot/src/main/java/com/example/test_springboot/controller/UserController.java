package com.example.test_springboot.controller;

import com.example.test_springboot.entity.Course;
import com.example.test_springboot.repository.CourseRepository;
import com.example.test_springboot.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public List<Course> getAllCourse(){
        return courseService.getAllCourse();
    }

    @GetMapping("/courses/online")
    public List<Course> getCourseByTypeOnline(){
        return courseService.getCourseByTypeOnline();
    }

    @GetMapping("/courses/onlab")
    public List<Course> getCourseByTypeOnlab(){
        return courseService.getCourseByTypeOnlab();
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable Integer id){
        return ResponseEntity.ok(courseService.getCourseById(id));
    }

    @GetMapping("/courses/search")
    public List<Course> searchByNameAndTopic(@RequestParam("name") String name,@RequestParam("topic") String topicName){
        return courseService.searchByNameAndTopic(name,topicName);
    }
}
