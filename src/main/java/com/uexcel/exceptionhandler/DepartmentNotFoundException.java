package com.uexcel.exceptionhandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DepartmentNotFoundException extends RuntimeException {
    private String message;
    private String time;

    public DepartmentNotFoundException(String message) {
        this.message = message;
        this.time = dateTime();
    }

    public String getMessage() {
        return message;
    }

    public String getTime() {
        return time;
    }

    public String dateTime() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        return formattedDate;

    }

}
