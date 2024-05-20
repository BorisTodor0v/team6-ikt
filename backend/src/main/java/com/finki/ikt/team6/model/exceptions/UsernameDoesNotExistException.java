package com.finki.ikt.team6.model.exceptions;

import org.springframework.http.HttpStatus;

public class UsernameDoesNotExistException extends RuntimeException {

    private HttpStatus status = HttpStatus.NOT_FOUND;

    public UsernameDoesNotExistException(String username){
        super(String.format("User with username: %s does not exist", username));
    }

    public HttpStatus getStatus() {
        return status;
    }
}
