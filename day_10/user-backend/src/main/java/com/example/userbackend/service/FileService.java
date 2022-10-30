package com.example.userbackend.service;

import com.example.userbackend.entity.Image;
import com.example.userbackend.entity.User;
import com.example.userbackend.exception.BadRequestException;
import com.example.userbackend.exception.NotFoundException;
import com.example.userbackend.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FileService {

    @Autowired
    private ImageRepository imageRepository;

    // svg
    public String uploadFile(User user, MultipartFile file) {
        validate(file);

        try {
            Image image = new Image();
            image.setUploadedAt(LocalDateTime.now());
            image.setData(file.getBytes());
            image.setUser(user);

            imageRepository.save(image);
            return "/api/v1/users/" + user.getId() + "/files/" + image.getId();
        } catch (IOException e) {
            throw new RuntimeException("Lỗi khi upload file");
        }
    }

    public void validate(MultipartFile file) {
        String fileName = file.getOriginalFilename();

        // Kiểm tra tên file
        if(fileName == null || fileName.equals("")) {
            throw new BadRequestException("Tên file không hợp lệ");
        }

        // avatar.png -> png
        // image.jpg -> jpg
        // Kiểm tra đuôi file
        String fileExtension = getFileExtension(fileName);
        if(!checkFileExtension(fileExtension)) {
            throw new BadRequestException("Định dạng file không hợp lệ");
        }

        // Kiểm tra dung lượng file (<= 2MB)
        if((double) file.getSize() / 1_048_576L > 2) {
            throw new BadRequestException("File không được vượt quá 2MB");
        }
    }

    private String getFileExtension(String fileName) {
        int lastIndexOf = fileName.lastIndexOf(".");
        if(lastIndexOf == -1) {
            return "";
        }
        return fileName.substring(lastIndexOf + 1);
    }

    private boolean checkFileExtension(String fileExtension) {
        List<String> extensions = Arrays.asList("jpg", "png", "jpeg");
        return extensions.contains(fileExtension.toLowerCase());
    }

    public byte[] readFile(Integer fileId) {
        Image image = imageRepository.findById(fileId).orElseThrow(() -> {
            throw new NotFoundException("Not found image with id = " + fileId);
        });
        return image.getData();
    }

    public List<String> getFiles(Integer id) {
        List<Image> images = imageRepository.findByUser_IdOrderByUploadedAtDesc(id);
        return images.stream()
                .map(image -> "/api/v1/users/" + id + "/files/" + image.getId())
                .collect(Collectors.toList());
    }

    public void deleteFile(Integer fileId) {
        Image image = imageRepository.findById(fileId).orElseThrow(() -> {
            throw new NotFoundException("Not found image with id = " + fileId);
        });
        imageRepository.delete(image);
    }
}
