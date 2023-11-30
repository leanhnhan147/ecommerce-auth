package com.ecommerce.auth.exception;

public class UnauthorizationException extends RuntimeException{
    public UnauthorizationException(String message){
        super(message);
    }
}
