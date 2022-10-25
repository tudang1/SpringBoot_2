package com.example.test_springboot.service;

import com.example.test_springboot.entity.Course;
import com.example.test_springboot.exception.NotFoundException;
import com.example.test_springboot.repository.CourseRepository;
import com.example.test_springboot.repository.TopicRepository;
import com.example.test_springboot.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    public List<Course> getCourseByTypeOnline() {
        return courseRepository.findByType("online");
    }

    public List<Course> getCourseByTypeOnlab() {
        return courseRepository.findByType("onlab");
    }

    public Course getCourseById(Integer id) {
        Optional<Course> courseOptional = courseRepository.findById(id);
        if (courseOptional.isPresent()) {
            return courseOptional.get();
        }
        throw new NotFoundException("Not found Course by id = " + id);
    }


    public List<Course> searchByNameAndTopic(String name, String topicName) {
        if (topicName == null || topicName == ""){
            List<Course> search = courseRepository.findByNameContains(name);
            if (search.isEmpty()){
                throw new NotFoundException("Not found Course by name = " + name);
            }
            return search;
        }
        return null;

    }
}
