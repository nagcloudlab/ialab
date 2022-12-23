package com.example.api;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class HttpError {
    private HttpStatus code;
    private String message;
}
