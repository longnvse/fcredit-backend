package com.fu.fcredit.user.controller;

import com.fu.fcredit.email.service.EmailService;
import com.fu.fcredit.user.entity.User;
import com.fu.fcredit.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;
    private EmailService emailService;

    @Autowired
    public UserController(UserService userService, EmailService emailService) {
        this.userService = userService;
        this.emailService = emailService;
    }

    @PostMapping("/users/register")
    public ResponseEntity<?> register(@RequestHeader(name = "host") String host,
                                      @RequestBody User user) {

        return userService.register(user, host);
    }

    @GetMapping("/send-mail")
    public ResponseEntity<?> sendMail(@RequestParam(name = "email") String email) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(email);
        mailMessage.setFrom("fcredit.fu@gmail.com");
        mailMessage.setSubject("Subject");
        mailMessage.setText("This is content");
        emailService.sendEmail(mailMessage);

        return ResponseEntity.ok("Email sent!");
    }
}
