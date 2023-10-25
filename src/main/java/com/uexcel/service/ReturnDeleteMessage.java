package com.uexcel.service;

import org.springframework.http.HttpStatus;

public class ReturnDeleteMessage {
    private String time;
    private HttpStatus status;
    private String message;

    public ReturnDeleteMessage(String time, HttpStatus status, String message) {
        this.time = time;
        this.status = status;
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
