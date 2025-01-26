package com.infocoder.service.saloon.exception;

public class SaloonNotFoundException extends RuntimeException {
    public SaloonNotFoundException(String input) {
        super(input);
    }
}
