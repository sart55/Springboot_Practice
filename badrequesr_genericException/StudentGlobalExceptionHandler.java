package com.example.getmappingObject.restController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentGlobalExceptionHandler {
    @ExceptionHandler
    ResponseEntity<StudentResponseError> handleException(CustomException ce){
        StudentResponseError res = new StudentResponseError();
        res.setMessage(ce.getMessage());
        res.setStatus(HttpStatus.BAD_REQUEST.value());
        res.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(res,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    ResponseEntity<StudentResponseError> genericException(Exception ce){
        StudentResponseError res = new StudentResponseError();
        res.setMessage(ce.getMessage());
        res.setStatus(HttpStatus.BAD_REQUEST.value());
        res.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(res,HttpStatus.BAD_REQUEST);
    }
}
