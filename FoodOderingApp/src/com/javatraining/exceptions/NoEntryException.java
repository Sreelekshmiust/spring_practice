package com.javatraining.exceptions;

public class NoEntryException extends Exception{

    private static final long serialVersionUID = 1L;

    public NoEntryException() {
    }

    public NoEntryException(String message) {
        super(message);
    }

    public NoEntryException(Throwable cause) {
        super(cause);
    }
}
