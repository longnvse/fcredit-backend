package com.fu.fcredit.auth.login.validator;

import com.fu.fcredit.auth.login.model.LoginRequest;
import com.fu.fcredit.auth.recaptcha.ulti.ReCaptchaUtil;
import com.fu.fcredit.user.validate.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoginValidator {
    private final UserValidator userValidator;
    private final ReCaptchaUtil reCaptchaUtil;

    public void validateForLogin(LoginRequest request) {
//        reCaptchaUtil.verifyCaptcha(request.getCaptchaResponse());

        userValidator.validateForAuthenticate(request.getUsername(), request.getPassword());

        userValidator.validateForEnabled(request.getUsername());
    }
}
