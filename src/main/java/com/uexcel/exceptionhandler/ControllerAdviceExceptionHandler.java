package com.uexcel.exceptionhandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class ControllerAdviceExceptionHandler extends ResponseEntityExceptionHandler {
        String time = LocalDateTime.now().toString().substring(0, LocalDateTime.now().toString().indexOf("."))
                        .replace("T", " ");

        @ExceptionHandler(DepartmentNotFoundException.class)
        public ResponseEntity<ErrorMassage> departmentNotfoundExceptionHandler(DepartmentNotFoundException e) {
                ErrorMassage message = new ErrorMassage(time, HttpStatus.NOT_FOUND, e.getMessage());
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                .body(message);
        }

        @ExceptionHandler(org.springframework.web.method.annotation.MethodArgumentTypeMismatchException.class)
        public ResponseEntity<ErrorMassage> MethodArgumentTypeMismatchException() {

                ErrorMassage message = new ErrorMassage(time, HttpStatus.BAD_REQUEST,
                                "Unable to convert input type to department id");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                .body(message);
        }

        // @ExceptionHandler(org.springframework.web.HttpRequestMethodNotSupportedException.class)
        // public ResponseEntity<ErrorMassage> methodNotS() {
        // ErrorMassage massage = new ErrorMassage(HttpStatus.METHOD_NOT_ALLOWED,
        // "Method not available");
        // return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED)
        // .body(massage);
        // }

        // @ExceptionHandler(org.springframework.web.bind.MissingPathVariableException.class)
        // // @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
        // public ResponseEntity<ErrorMassage> internalServerError() {
        // ErrorMassage message = new ErrorMassage(HttpStatus.BAD_REQUEST,
        // "Error occurred; unable to fulfill yor request");
        // return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        // .body(message);

        // }

        // @ResponseStatus(HttpStatus.BAD_REQUEST)
        // @ExceptionHandler(org.springframework.http.converter.HttpMessageNotReadableException.class)
        // public String
        // invalidJSONSyntax(org.springframework.http.converter.HttpMessageNotReadableException
        // e) {
        // return "Invlid syntaxt";
        // }

}