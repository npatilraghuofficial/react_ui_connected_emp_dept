package com.poc.task1.exceptions;

import org.springframework.http.HttpStatus;
// CustomExceptionHandler.java
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<customeErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
        customeErrorResponse errorResponse = new customeErrorResponse("Resource not found", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
