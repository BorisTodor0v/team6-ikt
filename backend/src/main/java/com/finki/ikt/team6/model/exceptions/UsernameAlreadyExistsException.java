package com.finki.ikt.team6.model.exceptions;

import org.springframework.http.HttpStatus;

public class UsernameAlreadyExistsException extends RuntimeException{

    private HttpStatus status = HttpStatus.CONFLICT;

    public UsernameAlreadyExistsException(String username) {
        super(String.format("User with username: %s already exists", username));
    }

    public HttpStatus getStatus() {
        return status;
    }
}
