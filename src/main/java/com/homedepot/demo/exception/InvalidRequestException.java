package com.homedepot.demo.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Invalid Request body")
public class InvalidRequestException extends RuntimeException {
    public InvalidRequestException(String msg){
        super(msg);
    }
    public InvalidRequestException(String msg, Throwable cause){
        super(msg, cause);
    }

}
