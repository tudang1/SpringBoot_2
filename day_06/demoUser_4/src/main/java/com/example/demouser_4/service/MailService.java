package com.example.demouser_4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    @Autowired
    private JavaMailSender emailSender;

    public void sendMail(String email,String subject,String body){
        //create a simple mailMessage
        SimpleMailMessage message =new SimpleMailMessage();

        message.setTo(email);
        message.setSubject(subject);
        message.setText(body);

        //send message
        emailSender.send(message);
    }
}
