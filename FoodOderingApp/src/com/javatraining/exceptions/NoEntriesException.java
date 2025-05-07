package com.javatraining.exceptions;

public class NoEntriesException extends Exception{

    private static final long setrialVersionUID = 1L;

    public NoEntriesException() {
    }

    public NoEntriesException(String message) {
        super(message);
    }

    public NoEntriesException(Throwable cause) {
        super(cause);
    }
}
