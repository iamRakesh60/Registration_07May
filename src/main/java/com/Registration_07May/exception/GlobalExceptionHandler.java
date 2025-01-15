package com.Registration_07May.exception;

import com.Registration_07May.payload.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDto> resourceNotFound(ResourceNotFoundException r, WebRequest request){
        ErrorDto error = new ErrorDto(r.getMessage(),new Date(),request.getDescription(false)); /* If id use true at that time url print with
                            clint information like "uri": "uri=/api/v1/registration/10;client=0:0:0:0:0:0:0:1"
                            > If I use FALSE at that time url like "uri": "uri": "uri=/api/v1/registration/10" */
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handelGlobalException(Exception e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
