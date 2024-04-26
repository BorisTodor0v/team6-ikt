package com.finki.ikt.team6.model.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidJobIdException extends RuntimeException{
    private HttpStatus status = HttpStatus.BAD_REQUEST;
    public InvalidJobIdException(){
        super("The requested Job does not exist");
    }
    public HttpStatus getStatus() {
        return status;
    }
}
