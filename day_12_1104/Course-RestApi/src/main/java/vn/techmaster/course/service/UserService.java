package vn.techmaster.course.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.techmaster.course.entity.User;
import vn.techmaster.course.exception.NotFoundException;
import vn.techmaster.course.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User getUserById(Integer id) {
        return userRepository.findById(id).orElseThrow(()->{
            throw new NotFoundException("Not found course with id = " + id);
        });
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
