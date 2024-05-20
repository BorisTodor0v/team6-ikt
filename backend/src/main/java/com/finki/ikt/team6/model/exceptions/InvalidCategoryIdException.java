package com.finki.ikt.team6.model.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidCategoryIdException extends RuntimeException{
    private HttpStatus status = HttpStatus.BAD_REQUEST;
    public InvalidCategoryIdException(){
        super("The requested category does not exist");
    }

    public HttpStatus getStatus() {
        return status;
    }
}
