package com.uexcel.exceptionhandler;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMassage {
    private String time;
    private HttpStatus status;
    private String message;

}
