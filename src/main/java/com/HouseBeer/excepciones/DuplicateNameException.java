package com.HouseBeer.excepciones;

import org.springframework.http.HttpStatus;

public class DuplicateNameException  extends  Exception{

    public DuplicateNameException  (String errorMessage) {
        super("El nombre : " + errorMessage + " ya existe. Elija otro por favor");
    }
}
