package com.example.demouser_4.service;

import com.example.demouser_4.entity.Image;
import com.example.demouser_4.entity.User;
import com.example.demouser_4.exception.BadRequestException;
import com.example.demouser_4.exception.NotFoundException;
import com.example.demouser_4.repository.ImageRepository;
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

    public String uploadFile(User user, MultipartFile file){
        validate(file);
        try {
            Image image = new Image();
            image.setUploadedAt(LocalDateTime.now());
            image.setData(file.getBytes());
            image.setUser(user);

            imageRepository.save(image);
            return "api/v1/users/" + user.getId() + "/files/" + image.getId();
        }catch (IOException e){
            throw new RuntimeException("Lỗi khi upload file");
        }
    }

    public void validate(MultipartFile file){
        String fileName = file.getOriginalFilename();

        //kiểm tra tên file
        if (fileName == null || fileName.equals("")){
            throw new BadRequestException("tên file k hợp lệ");
        }
        // avatar.png -> png
        // image.jpg -> jpg
        // Kiểm tra đuôi file
        String fileExtension = getFileExtension(fileName);
        if (!checkFileExtension(fileExtension)){
            throw new BadRequestException("Định dạng file k hợp lệ");
        }
        //kiểm tra dung lượng file
        if ((double) file.getSize()/1_048_576L>2){
            throw new BadRequestException("File vượt quá dung lượng cho phép");
        }
    }
    //check xem đuôi có hợp lệ hay k?
    private boolean checkFileExtension(String fileExtension) {
        List<String> extensions = Arrays.asList("jpg","png","jpeg");
        return extensions.contains(fileExtension.toLowerCase());
    }

    //cắt đuôi trong tên file
    private String getFileExtension(String fileName){
        int lastIndexOf = fileName.lastIndexOf(".");
        if (lastIndexOf == -1){
            return "";
        }
        return fileName.substring(lastIndexOf + 1);
    }

    public byte[] readFile(Integer fileId){
        Image image = imageRepository.findById(fileId).orElseThrow(()->{
            throw new NotFoundException("Not found imaga with id = "+fileId);
        });
        return image.getData();

    }

}
