package com.ust.PharmaAssist.exception;

/**
 * Pharma Exception is thrown when any non business violation occurs
 */
public class PharmaException extends Exception{

   public PharmaException(String message) {
        super(message);
    }
}
