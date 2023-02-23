package com.fu.fcredit.auth.register.controller;

import com.fu.fcredit.auth.register.model.RegisterRequest;
import com.fu.fcredit.auth.register.service.RegisterService;
import com.fu.fcredit.auth.register.validator.RegisterValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class RegisterController {
    private final RegisterService service;
    private final RegisterValidator validator;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request,
                                           @RequestHeader(name = "host") String host) {
        validator.validateForRegister(request);

        return service.register(request, host);
    }

    @PostMapping("/verify-user")
    public ResponseEntity<String> confirmUserEmail(@RequestParam("token") String verificationCode) {
        validator.validateForVerifyEmail(verificationCode);

        return service.verifyEmail(verificationCode);
    }
}