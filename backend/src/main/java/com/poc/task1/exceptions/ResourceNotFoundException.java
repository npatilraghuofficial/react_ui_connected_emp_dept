package com.poc.task1.exceptions;
// ResourceNotFoundException.java
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue) {
        super(String.format("%s not found with %s : %s", resourceName, fieldName, fieldValue));
    }
}
