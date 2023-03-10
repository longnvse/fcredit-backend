package com.fu.fcredit.user.validate;

import com.fu.fcredit.exception.BadRequestException;
import com.fu.fcredit.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserValidator {
    private final UserRepository repository;
    private final AuthenticationManager authenticationManager;

    public void validateForExistUsername(String username) {
        if (!repository.existsUserByUsernameIgnoreCase(username)) {
            return;
        }

        throw new BadRequestException("Tên người dùng đã được sử dụng!");
    }

    public void validateForExistEmail(String email) {
        if (!repository.existsByEmailIgnoreCase(email)) {
            return;
        }

        throw new BadRequestException("Email đã được sử dụng!");
    }

    public void validateForEnabled(String username) {
        repository.findUserByUsernameIgnoreCase(username)
                .ifPresent(user -> {
                    if (!user.isEnabled()) {
                        throw new BadRequestException("Tài khoản của bạn chưa được kích hoạt!");
                    }
                });
    }

    public void validateForAuthenticate(String username,
                                        String password) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        username,
                        password
                )
        );
    }
}
