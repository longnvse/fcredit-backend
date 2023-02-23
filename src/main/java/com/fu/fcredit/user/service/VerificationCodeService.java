package com.fu.fcredit.user.service;

import com.fu.fcredit.email.service.EmailService;
import com.fu.fcredit.user.entity.User;
import com.fu.fcredit.user.entity.VerificationCode;
import com.fu.fcredit.user.repository.VerificationCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
public class VerificationCodeService {
    private final VerificationCodeRepository verificationCodeRepository;
    private final EmailService emailService;

    public void generateVerificationCode(User user, String appUrl) {
        VerificationCode verificationCode = new VerificationCode(user);

        verificationCodeRepository.save(verificationCode);

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(user.getEmail());
        mailMessage.setFrom("fcredit.fu@gmail.com");
        mailMessage.setSubject("Complete Registration!");
        String host = appUrl == null || appUrl.isBlank() ? "localhost:3000" : appUrl;
        String uri = host + "/confirm-user?token=" + verificationCode.getToken();
        String url = URLEncoder.encode(uri, StandardCharsets.UTF_8);
        String text = "To confirm your account, please click here : " + url;
        mailMessage.setText(text);
        emailService.sendEmail(mailMessage);

        System.out.println(text);
    }
}
