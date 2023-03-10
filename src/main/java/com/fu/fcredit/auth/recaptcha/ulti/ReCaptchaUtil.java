package com.fu.fcredit.auth.recaptcha.ulti;

import com.fu.fcredit.auth.recaptcha.model.ReCaptchaResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class ReCaptchaUtil {
    @Value("${google.recaptcha.url}")
    private String url;
    @Value("${google.recaptcha.secret.key}")
    private String secretKey;
    private final RestTemplate restTemplate;

    public boolean verifyCaptcha(String captchaResponse) {
        String params = "/secret=" + secretKey + "&response=" + captchaResponse;

        ReCaptchaResponse reCaptchaResponse = restTemplate.exchange(url + params, HttpMethod.POST, null, ReCaptchaResponse.class).getBody();

        return reCaptchaResponse != null && reCaptchaResponse.isSuccess();
    }
}
