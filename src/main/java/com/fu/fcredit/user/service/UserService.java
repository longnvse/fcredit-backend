package com.fu.fcredit.user.service;

import com.fu.fcredit.email.service.EmailService;
import com.fu.fcredit.user.entity.User;
import com.fu.fcredit.user.repository.UserRepository;
import com.fu.fcredit.user.repository.VerificationCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository repository;
    private VerificationCodeRepository verificationCodeRepository;
    private EmailService emailService;

    @Autowired
    public UserService(UserRepository repository,
                       VerificationCodeRepository verificationCodeRepository,
                       EmailService emailService) {
        this.repository = repository;
        this.verificationCodeRepository = verificationCodeRepository;
        this.emailService = emailService;
    }

    public ResponseEntity<?> register(User user, String appUrl) {
        if (repository.existsByEmailIgnoreCase(user.getEmail())) {
            return ResponseEntity.badRequest().body("Email đã được sử dụng!");
        }

        user.setEnabled(true);

        repository.save(user);

//        VerificationCode verificationCode = new VerificationCode(user);
//
//        verificationCodeRepository.save(verificationCode);
//
//        SimpleMailMessage mailMessage = new SimpleMailMessage();
//        mailMessage.setTo(user.getEmail());
//        mailMessage.setFrom("fcredit.fu@gmail.com");
//        mailMessage.setSubject("Complete Registration!");
//        mailMessage.setText("To confirm your account, please click here : "
//                + appUrl + "/confirm-account?token=" + verificationCode.getToken());
//        emailService.sendEmail(mailMessage);
//
//        System.out.println("Confirmation Token: " + verificationCode.getToken());

        return ResponseEntity.ok("Email kích hoạt tài khoản đã được gửi đến email của bạn!");
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = repository.findUserByUsernameIgnoreCase(username);
//        if (user == null) {
//            throw new UsernameNotFoundException(username);
//        }
//        return new CustomUserDetails(user);
//    }
//
//    @Transactional
//    public UserDetails loadUserById(Long id) {
//        User user = repository.findById(id).orElseThrow(
//                () -> new UsernameNotFoundException("User not found with id : " + id)
//        );
//
//        return new CustomUserDetails(user);
//    }
}
