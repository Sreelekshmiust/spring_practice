package com.ust.PharmaAssist.exception;

/**
 * Pharma Business Exception is thrown when a business violation occurs
 */
public class PharmaBusinessException extends Exception{
    private int errorCode;

    public PharmaBusinessException(String message) {
        super(message);
    }

    public PharmaBusinessException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
