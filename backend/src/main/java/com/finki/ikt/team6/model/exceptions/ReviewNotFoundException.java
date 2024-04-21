package com.finki.ikt.team6.model.exceptions;

public class ReviewNotFoundException extends RuntimeException{
    public ReviewNotFoundException(){
        super("Review is not found!");
    }
}
