package com.fu.fcredit.auth.register.controller;

import com.fu.fcredit.auth.register.model.RegisterRequest;
import com.fu.fcredit.auth.register.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class RegisterController {
    private final RegisterService service;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request,
                                           @RequestHeader(name = "host") String host) {
        return ResponseEntity.ok(service.register(request, host));
    }
}