package com.uexcel.exceptionhandler;

public class DepartmentNotFoundException extends RuntimeException {
    private String message;

    public DepartmentNotFoundException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
