package com.finki.ikt.team6.model.exceptions;

import org.springframework.http.HttpStatus;

public class CategoryAlreadyExistsException extends RuntimeException{
    private HttpStatus status = HttpStatus.CONFLICT;

    public CategoryAlreadyExistsException(String name) {
        super(String.format("Category with name: %s already exists", name));
    }

    public HttpStatus getStatus() {
        return status;
    }
}
