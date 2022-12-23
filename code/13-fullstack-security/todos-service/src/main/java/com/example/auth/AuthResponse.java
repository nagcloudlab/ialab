package com.example.auth;

import lombok.Data;

@Data
public class AuthResponse {

    private String accessToken;
    private String message;

}
