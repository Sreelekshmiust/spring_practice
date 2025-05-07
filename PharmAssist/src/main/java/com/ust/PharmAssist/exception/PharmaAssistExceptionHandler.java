package com.ust.PharmAssist.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global exception handler for handling PharmaException and PharmaBusinessException.
 */
@ControllerAdvice
public class PharmaAssistExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(PharmaAssistExceptionHandler.class);

    /**
     * Handles PharmaException and returns an HTTP 500 Internal Server Error response.
     *
     * @param ex The PharmaException that was thrown.
     * @return An HTTP response entity with the error message from the exception.
     */
    @ExceptionHandler(PharmaException.class)
    public ResponseEntity<String> handlePharmaException(PharmaException ex) {
        logger.error("PharmaException caught: " + ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }

    /**
     * Handles PharmaBusinessException and returns an HTTP response with error code and message.
     *
     * @param e The PharmaException that was thrown.
     * @return An HTTP response entity with the error message from the exception and the corresponding error code.
     */
    @ExceptionHandler(PharmaBusinessException.class)
    public ResponseEntity<String> handlePharmaBusinessException(PharmaBusinessException e){
        logger.error("PharmaBusinessException caught:"+e.getMessage());
        return ResponseEntity.status(e.getErrorCode()).body(e.getMessage());
    }
}
