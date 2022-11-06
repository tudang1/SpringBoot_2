package vn.techmaster.course.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.techmaster.course.entity.Course;
import vn.techmaster.course.entity.User;
import vn.techmaster.course.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("")
    public ResponseEntity<?> getUsers() {
        List<User> users = userService.getUsers();
        return ResponseEntity.ok(users);
    }
    @GetMapping("{id}")
    public ResponseEntity<?> getUserById(@PathVariable Integer id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }
}
