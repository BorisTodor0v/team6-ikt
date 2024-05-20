package com.finki.ikt.team6.model.exceptions;

import org.springframework.http.HttpStatus;

public class UserIdDoesNotExistException extends RuntimeException{
    private HttpStatus status = HttpStatus.NOT_FOUND;

    public UserIdDoesNotExistException(Long id){
        super(String.format("User with the id: %s does not exist", id.toString()));
    }

    public HttpStatus getStatus() {
        return status;
    }
}
