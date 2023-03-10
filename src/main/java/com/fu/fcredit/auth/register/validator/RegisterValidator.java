package com.fu.fcredit.auth.register.validator;

import com.fu.fcredit.auth.recaptcha.ulti.ReCaptchaUtil;
import com.fu.fcredit.auth.register.model.RegisterRequest;
import com.fu.fcredit.exception.BadRequestException;
import com.fu.fcredit.user.validate.UserValidator;
import com.fu.fcredit.user.validate.VerificationCodeValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegisterValidator {
    private final UserValidator userValidator;
    private final VerificationCodeValidator verificationCodeValidator;
    private final ReCaptchaUtil reCaptchaUtil;

    private static final String EMAIL_REQUEST = "Vui lòng nhập email!";

    private static final String USERNAME_REQUEST = "Vui lòng nhập tên người dùng!";

    private static final String PASSWORD_REQUEST = "Vui lòng nhập mật khẩu!";

    public void validateForRegister(RegisterRequest request) {
        isNotPopulated(request.getUsername(), USERNAME_REQUEST);
        isNotPopulated(request.getEmail(), EMAIL_REQUEST);
        isNotPopulated(request.getPassword(), PASSWORD_REQUEST);
//        reCaptchaUtil.verifyCaptcha(request.getCaptchaResponse());

        userValidator.validateForExistEmail(request.getEmail());
        userValidator.validateForExistUsername(request.getUsername());
    }

    public void validateForVerifyEmail(String token) {
        verificationCodeValidator.validateForExistToken(token);
        verificationCodeValidator.validateForUsed(token);
        verificationCodeValidator.validateForExpired(token);
    }

    private void isNotPopulated(String value, String errorMsg) {
        if (null == value || value.trim().isEmpty()) {
            throw new BadRequestException(errorMsg);
        }
    }
}
