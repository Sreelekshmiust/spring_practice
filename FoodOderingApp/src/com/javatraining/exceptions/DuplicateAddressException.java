package com.javatraining.exceptions;

public class DuplicateAddressException extends Exception{

    private static final long serialVersionUID= 1L;

    public DuplicateAddressException() {
    }

    public DuplicateAddressException(String message) {
        super(message);
    }

    public DuplicateAddressException(Throwable cause) {
        super(cause);
    }
}
