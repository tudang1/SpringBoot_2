package vn.techmaster.course.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import vn.techmaster.course.entity.Course;
import vn.techmaster.course.entity.Topic;
import vn.techmaster.course.entity.User;
import vn.techmaster.course.exception.NotFoundException;
import vn.techmaster.course.repository.CourseRepository;
import vn.techmaster.course.repository.TopicRepository;
import vn.techmaster.course.repository.UserRepository;
import vn.techmaster.course.request.UpsertCourseRequest;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private final TopicRepository topicRepository;
    private final ImageService imageService;

    public List<Course> getSources() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Integer id) {
        return courseRepository.findById(id).orElseThrow(()->{
            throw new NotFoundException("Not found course with id = " + id);
        });
    }

    public Course createCourse(UpsertCourseRequest request) {
        //tim kiếm user theo id
        User user = userRepository.getUserById(request.getUserId());

        //tìm kiếm topic theo ID
        Set<Topic> topics = topicRepository.findByIdIn(request.getTopicsId());

        Course course = new Course();
        course.setName(request.getName());
        course.setType((request.getType()));
        course.setDescription(request.getDescription());
        course.setTopics(topics);
        course.setUser(user);

        return courseRepository.save(course);
    }

    public Course updateCourse(Integer id, UpsertCourseRequest request) {
        Course course = courseRepository.findById(id).orElseThrow(()->{
            throw new NotFoundException("Not found course with id = "+ id);
        });
        course.setName(request.getName());
        course.setType(request.getType());
        course.setDescription(request.getDescription());
        course.setTopics(topicRepository.findByIdIn(request.getTopicsId()));
        course.setUser(userRepository.getUserById(request.getUserId()));

        return courseRepository.save(course);
    }

    public void deleteCourse(Integer id) {
        Course course = courseRepository.findById(id).orElseThrow(()->{
            throw new NotFoundException("Not found course with id = "+ id);
        });
        courseRepository.delete(course);
    }

    public String uploadThumbnail(Integer id, MultipartFile file) {
        Course course = courseRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found course with id = " + id);
        });

        String path = imageService.uploadImage(file);
        course.setThumbnail(path);

        courseRepository.save(course);

        return path;
    }
}
