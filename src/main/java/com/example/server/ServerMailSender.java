package com.example.server;


import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class ServerMailSender {
    JavaMailSender mailSender;
    public ServerMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Async
    public void sendEmailActivationCode(String username, int activecode, String email) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setText("welcome "+username+", your activation code is "+activecode);
        simpleMailMessage.setTo(email);
        simpleMailMessage.setSubject("Chat Activation Code");
        mailSender.send(simpleMailMessage);
    }
}
