package com.example.lab14.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@Service
@Async
public class EmailService {
    @Autowired
    private JavaMailSender emailSender;

    private static final String email= "khokhlowictor@gmail.com";

    public void sendMessage(String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);

    }
}
