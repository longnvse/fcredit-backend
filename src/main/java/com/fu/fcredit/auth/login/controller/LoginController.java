package com.fu.fcredit.auth.login.controller;

import com.fu.fcredit.auth.login.model.LoginRequest;
import com.fu.fcredit.auth.login.model.LoginResponse;
import com.fu.fcredit.auth.login.service.LoginService;
import com.fu.fcredit.auth.login.validator.LoginValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class LoginController {
    private final LoginService service;
    private final LoginValidator validator;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(
            @RequestBody LoginRequest request
    ) {
        validator.validateForLogin(request);

        return ResponseEntity.ok(service.login(request));
    }
}