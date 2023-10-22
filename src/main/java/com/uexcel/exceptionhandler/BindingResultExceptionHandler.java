package com.uexcel.exceptionhandler;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseStatus
public class BindingResultExceptionHandler {

    @ExceptionHandler(DataBindingException.class)
    public ResponseEntity<ArrayList<ErrorMassage>> validationExceptHandler(DataBindingException e) {
        ArrayList<ErrorMassage> errList = new ArrayList<>();
        ErrorMassage msg;

        // = new ErrorMassage(HttpStatus.BAD_REQUEST, e.getMessage());
        // errList.add(msg);
        // return ResponseEntity.status(HttpStatus.BAD_REQUEST)

        // .body(errList);

        String mainMassage = e.getMessage().substring(e.getMessage().indexOf("?#") + 2);
        String time = e.dateTime();
        boolean isDoubleMassage = mainMassage.contains("?#");

        if (!isDoubleMassage) {
            msg = new ErrorMassage(time, HttpStatus.BAD_REQUEST,
                    mainMassage.substring(0, mainMassage.indexOf("#?")));
            errList.add(msg);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(errList);

        }

        String secondMsg = mainMassage.substring(mainMassage.indexOf("#?") + 3);

        msg = new ErrorMassage(time, HttpStatus.BAD_REQUEST,
                mainMassage.substring(0, mainMassage.indexOf("#?") + 2));

        ErrorMassage msg2 = new ErrorMassage(time, HttpStatus.BAD_REQUEST,
                secondMsg.substring((secondMsg.indexOf("?#") + 2), secondMsg.indexOf("#?")));

        errList.add(msg);
        errList.add(msg2);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errList);

    }

}
