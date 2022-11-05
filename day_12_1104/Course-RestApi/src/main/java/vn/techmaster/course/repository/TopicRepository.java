package vn.techmaster.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.techmaster.course.entity.Topic;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Integer> {
    Set<Topic> findByIdIn(List<Integer> ids);

    List<Topic> findByName(String name);

}