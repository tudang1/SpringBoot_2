package vn.techmaster.course.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.techmaster.course.entity.Topic;
import vn.techmaster.course.exception.BadRequestException;
import vn.techmaster.course.exception.NotFoundException;
import vn.techmaster.course.repository.TopicRepository;
import vn.techmaster.course.request.UpsertTopicRequest;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TopicService {
    private final TopicRepository topicRepository;

    public List<Topic> getTopic() {
        return  topicRepository.findAll();
    }

    public Topic getTopicById(Integer id) {
        return topicRepository.findById(id).orElseThrow(()->{
            throw new NotFoundException("Not found course with id = " + id);
        });
    }

    public Topic createTopic(UpsertTopicRequest request) {
        List<Topic> topic = topicRepository.findByName(request.getName());
        if (topic.isEmpty()){
            Topic newToppic = new Topic();
            newToppic.setName(request.getName());
            return topicRepository.save(newToppic);
        }
        throw new BadRequestException("topic đã tồn tại");
    }

    public Topic updateTopic(Integer id, UpsertTopicRequest request) {
        Topic topic = topicRepository.findById(id).orElseThrow(()->{
            throw new NotFoundException("Not found course with id = " + id);
        });
        topic.setName(request.getName());
        return topicRepository.save(topic);
    }

    public void deleteTopic(Integer id) {

    }
}
