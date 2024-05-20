package com.finki.ikt.team6.model.exceptions;

import org.springframework.http.HttpStatus;

public class UserFilteringException extends RuntimeException{

    private HttpStatus status = HttpStatus.NOT_FOUND;

    public UserFilteringException(String message){
        super(message);
    }
    public HttpStatus getStatus(){
        return status;
    }
}
