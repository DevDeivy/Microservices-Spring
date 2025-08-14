package com.DevDeivy.microservices.costumer_microservices.exceptions;

import com.microservices.common_exceptions.ErrorResponse;
import com.microservices.common_exceptions.GlobalExceptionHandler;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
@Primary
public class CustomerExceptionHandler extends GlobalExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ErrorResponse> handler(CustomerNotFoundException exception){
        var errors = new HashMap<String, String>();
        var fielName = "Customers";
        errors.put(fielName, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(errors));
    }
}
