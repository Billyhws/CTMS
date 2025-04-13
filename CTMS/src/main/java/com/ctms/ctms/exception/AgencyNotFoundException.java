package com.ctms.ctms.exception;


public class AgencyNotFoundException extends RuntimeException{

    public AgencyNotFoundException() {
        super();
    }


    public AgencyNotFoundException(String message) {
        super(message);
    }
}