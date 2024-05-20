package com.finki.ikt.team6.model.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidEmailOrPasswordException extends RuntimeException {
    private HttpStatus status = HttpStatus.BAD_REQUEST;

    public InvalidEmailOrPasswordException(){
        super("Invalid email or password");
    }

    public HttpStatus getStatus() {
        return status;
    }
}
