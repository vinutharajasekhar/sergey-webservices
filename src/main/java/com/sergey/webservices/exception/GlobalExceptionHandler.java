package com.sergey.webservices.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity<Object> handleNullPointerException(NullPointerException ex ){
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setMessage(ex.getLocalizedMessage() + " Null Pointer Exception");
        errorInfo.setTimestamp(new Date());

        return new ResponseEntity<>(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex ){
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setMessage(ex.getLocalizedMessage() );
        errorInfo.setTimestamp(new Date());

        return new ResponseEntity<>(errorInfo, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handleAnyException(Exception ex , WebRequest request){
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setMessage(ex.getLocalizedMessage());
        errorInfo.setTimestamp(new Date());

        return new ResponseEntity<>(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
