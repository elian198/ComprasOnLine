package com.HouseBeer.excepciones;

import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetail> handlerResourceNotFoundException(ResourceNotFoundException ex,
                                                                        WebRequest webRequest){
        ErrorDetail errorDetail = new ErrorDetail(LocalDateTime.now(),
                ex.getMessage(),
                webRequest.getDescription(false),
        "NOT FOUND");
        return  new ResponseEntity<>(errorDetail, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicateNameException.class)
    public ResponseEntity<ErrorDetail> duplicateNameException(DuplicateNameException ex,
                                                                        WebRequest webRequest){
        ErrorDetail errorDetail = new ErrorDetail(LocalDateTime.now(),
                ex.getMessage(),
                webRequest.getDescription(false),
                "OK");
        return  new ResponseEntity<>(errorDetail, HttpStatus.ACCEPTED);
    }

}
