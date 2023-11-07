package com.poc.task1.exceptions;

import lombok.Getter;
import lombok.Setter;

// CustomErrorResponse.java
@Getter
@Setter
public class customeErrorResponse {
    private String message;
    private String details;

    public customeErrorResponse(String message, String details) {
        this.message = message;
        this.details = details;
    }

    // Getters and setters
}
