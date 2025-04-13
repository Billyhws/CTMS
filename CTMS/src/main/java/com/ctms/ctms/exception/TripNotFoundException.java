package com.ctms.ctms.exception;

public class TripNotFoundException extends RuntimeException{

    public TripNotFoundException() {
        super();
    }

    public TripNotFoundException(String message) {
        super(message);
    }
}
