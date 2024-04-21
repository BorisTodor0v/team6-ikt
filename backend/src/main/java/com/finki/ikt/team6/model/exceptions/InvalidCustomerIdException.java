package com.finki.ikt.team6.model.exceptions;

public class InvalidCustomerIdException extends RuntimeException{
    public InvalidCustomerIdException(){
        super("Invalid id for customer.");
    }
}
