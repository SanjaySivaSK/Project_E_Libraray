package com.restapi.exception.common;

import org.springframework.http.HttpStatus;

public class AppException extends RuntimeException {

    private HttpStatus status;
    private String message;

    public AppException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public AppException(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
