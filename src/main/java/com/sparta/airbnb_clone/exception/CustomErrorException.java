package com.sparta.airbnb_clone.exception;

public class CustomErrorException extends RuntimeException {
    public CustomErrorException(String msg) {
        super(msg);
    }
}