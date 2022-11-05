package vn.techmaster.course.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vn.techmaster.course.entity.Course;
import vn.techmaster.course.request.UpsertCourseRequest;
import vn.techmaster.course.service.CourseService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping("")
    public ResponseEntity<?> getCourses() {
        List<Course> courses = courseService.getSources();
        return ResponseEntity.ok(courses);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getCourseById(@PathVariable Integer id) {
        Course course = courseService.getCourseById(id);
        return ResponseEntity.ok(course);
    }

    @PostMapping("")//201
    public ResponseEntity<?> createCourse(@RequestBody UpsertCourseRequest request) {
        Course course = courseService.createCourse(request);
        return new ResponseEntity<>(course , HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateCourse(@PathVariable Integer id,@RequestBody UpsertCourseRequest request) {
        Course course = courseService.updateCourse(id,request);
        return ResponseEntity.ok(course);
    }

    @DeleteMapping("{id}")
    public void deleteCourse(@PathVariable Integer id) {
        courseService.deleteCourse(id);
    }

    @PostMapping("{id}/upload-thumbnail")
    public ResponseEntity<?> uploadFile(@PathVariable Integer id, @ModelAttribute("file") MultipartFile file) {
        String path = courseService.uploadThumbnail(id, file);
        return ResponseEntity.ok(path);
    }
}
