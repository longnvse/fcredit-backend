package com.fu.fcredit.user.validate;

import com.fu.fcredit.exception.BadRequestException;
import com.fu.fcredit.exception.EntityNotFoundException;
import com.fu.fcredit.token.service.JwtService;
import com.fu.fcredit.user.entity.User;
import com.fu.fcredit.user.model.ChangePasswordRequest;
import com.fu.fcredit.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserValidator {
    private final UserRepository repository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

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

    public void validateForChangePassword(String username,
                                          ChangePasswordRequest passwordRequest) {

        validateForOldPassword(username, passwordRequest.getOldPassword());
        validateForNewPassword(passwordRequest.getNewPassword(), passwordRequest.getReNewPassword());

    }

    private void validateForOldPassword(String username,
                                        String oldPassword) {
        User user = repository.findUserByUsernameIgnoreCase(username).orElseThrow(() -> new EntityNotFoundException("Người dùng không tồn tại!"));

        if (passwordEncoder.matches(oldPassword, user.getPassword())) {
            return;
        }

        throw new BadRequestException("Mật khẩu cũ không đúng!");
    }

    private void validateForNewPassword(String newPassword,
                                        String reNewPassword) {
        if (newPassword.length() < 8 || newPassword.length() > 16) {
            throw new BadRequestException("Mật khẩu phải từ 8 - 16 kí tự!");
        }

        if (newPassword.equals(reNewPassword)) {
            return;
        }

        throw new BadRequestException("Mật khẩu nhập lại không khớp với mật khẩu mới!");

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
