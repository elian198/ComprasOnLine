package com.HouseBeer.excepciones;

import org.springframework.http.HttpStatus;

public class DuplicateNameException  extends  RuntimeException{
   private  String message;
    public DuplicateNameException  (String errorMessage) {
        super( errorMessage);
        this.message = errorMessage;
    }
}
