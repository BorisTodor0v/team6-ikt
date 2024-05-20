package com.finki.ikt.team6.model.exceptions;

import org.springframework.http.HttpStatus;

public class PasswordsDoNotMatchException extends RuntimeException {

    private HttpStatus status = HttpStatus.BAD_REQUEST;

    public PasswordsDoNotMatchException() {
        super("The Password and Repeat password fields do not match.");
    }

    public HttpStatus getStatus() {
        return status;
    }
}

