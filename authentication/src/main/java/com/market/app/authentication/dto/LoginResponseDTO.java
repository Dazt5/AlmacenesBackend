package com.market.app.authentication.dto;

public class LoginResponseDTO {

    private String message;
    private String Token;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }
}
