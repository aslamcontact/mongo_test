package com.aslam.mycontact.exceptions;

import com.aslam.mycontact.daolayer.catelog.Pricing.Price;
import org.springframework.http.HttpStatus;

public class ExceptionParse {
     private final String message;
     private final HttpStatus httpStatus;


    public ExceptionParse(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }


}
