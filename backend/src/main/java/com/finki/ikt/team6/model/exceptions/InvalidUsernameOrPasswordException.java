package com.finki.ikt.team6.model.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidUsernameOrPasswordException extends RuntimeException {
    private HttpStatus status = HttpStatus.BAD_REQUEST;

    public InvalidUsernameOrPasswordException(){
        super("Invalid username or password");
    }

    public HttpStatus getStatus() {
        return status;
    }
}
