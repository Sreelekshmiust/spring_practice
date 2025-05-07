package com.example.foodDelivery.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(value=NoEntryException.class)
    public ResponseEntity<String> handleNoEntryException(NoEntryException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value=NoEntriesException.class)
    public ResponseEntity<String> handleNoEntriesException(NoEntriesException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value=DuplicateAddressException.class)
    public ResponseEntity<String> handleDuplicateException(DuplicateAddressException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
