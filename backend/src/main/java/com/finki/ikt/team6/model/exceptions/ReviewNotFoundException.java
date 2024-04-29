package com.finki.ikt.team6.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ReviewNotFoundException extends RuntimeException{
    private HttpStatus status = HttpStatus.NOT_FOUND;
    public ReviewNotFoundException(){
        super("Review is not found!");
    }


    public HttpStatus getStatus() {
        return status;
    }
}
