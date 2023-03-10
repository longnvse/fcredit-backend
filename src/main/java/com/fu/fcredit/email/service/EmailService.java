package com.fu.fcredit.email.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender javaMailSender;

    public void sendEmail(SimpleMailMessage email) {
        try {
            javaMailSender.send(email);
        } catch (MailException ex) {
            ex.printStackTrace();
        }
    }
}
