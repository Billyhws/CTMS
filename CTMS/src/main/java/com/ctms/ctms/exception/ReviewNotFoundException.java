package com.ctms.ctms.exception;


public class ReviewNotFoundException extends RuntimeException{

    public ReviewNotFoundException() {
        super();
    }


    public ReviewNotFoundException(String message) {
        super(message);
    }
}