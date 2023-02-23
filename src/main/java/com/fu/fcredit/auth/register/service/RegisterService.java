package com.fu.fcredit.auth.register.service;

import com.fu.fcredit.auth.register.model.RegisterRequest;
import com.fu.fcredit.user.entity.User;
import com.fu.fcredit.user.repository.UserRepository;
import com.fu.fcredit.user.service.VerificationCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
@RequiredArgsConstructor
public class RegisterService {
    private final UserRepository repository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final VerificationCodeService verificationCodeService;

    public String register(RegisterRequest request,
                           String appUrl) {
        User user = User.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        User savedUser = repository.save(user);

        verificationCodeService.generateVerificationCode(savedUser, appUrl);

        return "Đăng ký thành công!";
    }

}
