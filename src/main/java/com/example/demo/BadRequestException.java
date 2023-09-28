package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,
        reason = "This question already exists")
public class BadRequestException extends RuntimeException{
    public BadRequestException(String message) {
        super(message);
    }
}
