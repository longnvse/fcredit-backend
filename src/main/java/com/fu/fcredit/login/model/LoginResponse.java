package com.fu.fcredit.login.model;

import lombok.Data;

@Data
public class LoginResponse {
    private String accessToken;
    private static final String TOKEN_TYPE = "Bearer";

    public LoginResponse(String accessToken) {
        this.accessToken = accessToken;
    }
}
