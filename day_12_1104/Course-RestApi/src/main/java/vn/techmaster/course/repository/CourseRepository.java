package vn.techmaster.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.techmaster.course.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
}