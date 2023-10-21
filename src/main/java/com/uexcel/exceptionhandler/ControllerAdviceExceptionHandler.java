package com.uexcel.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerAdviceExceptionHandler {
    @ResponseBody
    @ExceptionHandler(DepartmentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String departmentNotfoundExceptionHandler(DepartmentNotFoundException e) {
        return e.getMessage();
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(org.springframework.web.method.annotation.MethodArgumentTypeMismatchException.class)
    public String MethodArgumentTypeMismatchException() {
        return "Bad Request";
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(org.springframework.web.HttpRequestMethodNotSupportedException.class)
    public String notFoundException() {
        return "Method Not Allowed";
    }

    @ResponseBody
    @ExceptionHandler(org.springframework.web.bind.MissingPathVariableException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String internalServerError() {
        return "Internal Server Error";
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(org.springframework.web.bind.MethodArgumentNotValidException.class)
    public String validationExceptHandler(org.springframework.web.bind.MethodArgumentNotValidException e) {

        String mainMassage = e.getMessage().substring(e.getMessage().indexOf("default message"));

        String message = mainMassage.substring(51);

        boolean isDoubleMassage = message.contains("default message");

        if (!isDoubleMassage) {
            return message.replace("]", "").replace("[", "");
        }

        return message.substring(message.indexOf("default message")).substring(51).replace("]", "")
                .replace("[", "")
                + "\n" + message.substring(0, message.indexOf("Field")).replace("]", "").replace("[", "");

    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(org.springframework.http.converter.HttpMessageNotReadableException.class)
    public String invalidJSONSyntax(org.springframework.http.converter.HttpMessageNotReadableException e) {
        return "Invlid syntaxt";
    }

}