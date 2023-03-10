package com.fu.fcredit.user.service;

import com.fu.fcredit.email.service.EmailService;
import com.fu.fcredit.user.entity.User;
import com.fu.fcredit.user.entity.VerificationCode;
import com.fu.fcredit.user.repository.UserRepository;
import com.fu.fcredit.user.repository.VerificationCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VerificationCodeService {
    private final VerificationCodeRepository repository;
    private final EmailService emailService;
    private final UserRepository userRepository;

    public void generateVerificationCode(User user, String appUrl) {
        VerificationCode verificationCode = new VerificationCode(user);

        repository.save(verificationCode);

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(user.getEmail());
        mailMessage.setFrom("fcredit.fu@gmail.com");
        String subject = "[Thông báo] - Kích hoạt tài khoản FCredit!";

        mailMessage.setSubject(subject);
        String host = appUrl == null || appUrl.isBlank() ? "localhost:3000" : appUrl;
        String url = host + "/verify-user?token=" + verificationCode.getToken();
//        String url = URLEncoder.encode(uri, StandardCharsets.UTF_8);
        String text = "Vui lòng truy cập đường dẫn: " + url + " để kích hoạt tài khoản!";
        mailMessage.setText(text);

        emailService.sendEmail(mailMessage);

        System.out.println(text);
    }

    public ResponseEntity<String> verifyEmail(String token) {
        VerificationCode verificationCode = repository.findVerificationCodeByToken(token);

        verificationCode.getUser().setEnabled(true);
        verificationCode.setUsed(true);
        userRepository.save(verificationCode.getUser());
        repository.save(verificationCode);

        return ResponseEntity.ok("Thành công!");
    }
}
