package com.example.demouser_4.service;

import com.example.demouser_4.dto.UserDto;
import com.example.demouser_4.entity.User;
import com.example.demouser_4.exception.BadRequestException;
import com.example.demouser_4.exception.NotFoundException;
import com.example.demouser_4.repository.UserRepository;
import com.example.demouser_4.request.CreateUser;
import com.example.demouser_4.request.UpdateAvatarRequest;
import com.example.demouser_4.request.UpdateInfoUser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MailService mailService;

    @Autowired
    private FileService fileService;

    @Autowired
    private ModelMapper modelMapper;

    public List<UserDto> getUsers(){
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> modelMapper.map(user,UserDto.class))
                .collect(Collectors.toList());
    }

    public UserDto getUserById(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()){
            return modelMapper.map(userOptional.get(),UserDto.class);
        }
        throw new NotFoundException("Not found user with id = " +id );

    }

    public UserDto createUser(CreateUser request) {
        List<User> check = userRepository.findByEmail(request.getEmail());
        if (check.isEmpty()){
            User user = User.builder()
                    .name(request.getName())
                    .email(request.getEmail())
                    .phone(request.getPhone())
                    .address(request.getAddress())
                    .password(request.getPassword())
                    .build();
            userRepository.save(user);
            return modelMapper.map(user,UserDto.class);
        }
        throw new BadRequestException("Email ???? t???n t???i");
    }

    public void updateInfoUser(Integer id, UpdateInfoUser request) {
        User user = userRepository.findById(id).orElseThrow(()->{
            throw new NotFoundException("Not found user with id = "+id);
        });
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setAddress(request.getAddress());
        //kiem tra oldPassword chinh xac k?
        if (!user.getPassword().equals(request.getOldPassword())){
            throw new BadRequestException("m???t kh???u c?? k ch??nh x??c");
        }

        //ki???m tra new password c?? v?? m???i c?? tr??ng nhau hay k?
        if (request.getOldPassword().equals(request.getNewPassword())){
            throw new BadRequestException("M???t kh???u m???i k ??c tr??ng v???i mk c??");
        }
        user.setPassword(request.getNewPassword());
        userRepository.save(user);

        throw new RuntimeException("c???p nh???p th??nh c??ng");
    }

    public void deleteById(Integer id) {
        User user = userRepository.findById(id).orElseThrow(()->{
            throw new NotFoundException("Not found user with id = "+id);
        });
        userRepository.deleteById(id);
        throw new RuntimeException("X??a Th??nh C??ng");
    }

    public void updateAvatar(Integer id, UpdateAvatarRequest request) {
        User user = userRepository.findById(id).orElseThrow(()->{
            throw new NotFoundException("Not found user with id = "+ id );
        });
        user.setAvatar(request.getAvatar());
        userRepository.save(user);
    }

    public String forgorPassword(Integer id) {
        User user = userRepository.findById(id).orElseThrow(()->{
            throw new NotFoundException("Not found user with id = "+id);
        });
        //genarate password
        String newPassword = UUID.randomUUID().toString();

        user.setPassword(newPassword);
        userRepository.save(user);

        //send mail
        mailService.sendMail(user.getEmail(),"Quen mk", "mat khau moi: "+ newPassword);
        return newPassword;
    }

    public String uploadFile(Integer id, MultipartFile file) {
        User user = userRepository.findById(id).orElseThrow(()->{
            throw new NotFoundException("Not found user with id = "+id);
        });
        return fileService.uploadFile(user , file);
    }

    public byte[] readFile(Integer id, Integer fileId) {
        User user = userRepository.findById(id).orElseThrow(()->{
            throw new NotFoundException("Not found user with by id = "+ id);
        });
        return fileService.readFile(fileId);
    }

    public List<String> getFiles(Integer id) {
        return null;
    }

    public void deleteFile(Integer fileId) {
    }
}
