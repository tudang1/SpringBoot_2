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
import java.util.Locale;

@Service
public class FileService {
    @Autowired
    private ImageRepository imageRepository;

    public String uploadFile(User user, MultipartFile file) {
        validate(file);

        try {
            Image image = new Image();
            image.setUploadedAt(LocalDateTime.now());
            image.setData(file.getBytes());
            image.setUser(user);

            imageRepository.save(image);
            return "/api/v1/users/" + user.getId() + "/files/" + image.getId();
        }catch (IOException e){
            throw new RuntimeException("lỗi upload file");
        }

    }

    public void validate(MultipartFile file){
        String fileName = file.getOriginalFilename();
        //kt tên file
        if (fileName == null || fileName.equals("")){
            throw new BadRequestException("Tên file k hợp lệ");
        }
        //Kt đuôi file
        String fileExtension = getFileExtension(fileName);
        if (!checkFileExtension(fileExtension)) {
            throw new BadRequestException("định dạng file k hợp lệ");
        }

        //kt dung lượng file
        if ((double)file.getSize()/ 1_040_576L > 2){
            throw new BadRequestException("File k đc vượt quá 2Mb");
        }
    }

    private String getFileExtension(String fileName){
        int lastIndexOf = fileName.lastIndexOf(".");
        if (lastIndexOf == -1 ){
            return "";
        }
        return fileName.substring(lastIndexOf + 1 );
    }

    private boolean checkFileExtension(String fileExtension){
        List<String> extension = Arrays.asList("jpg","jpeg","png");
        return extension.contains(fileExtension.toLowerCase());
    }

    public byte[] readFile(Integer fileId) {
        Image image = imageRepository.findById(fileId).orElseThrow(()->{
            throw new NotFoundException("Not found image with id = "+ fileId);
        });
        return image.getData();
    }
}
