package com.reward.api.core.exception;

public class DomainException extends RuntimeException {
    
    public DomainException() {
        super();
    }

    public DomainException(String message) {
        super(message);
    }
}