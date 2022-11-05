package vn.techmaster.course.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/images")
@RequiredArgsConstructor
public class ImageController {
    // Xem image
    @GetMapping("{id}")
    public ResponseEntity<?> readFile() {
        return null;
    }
}
