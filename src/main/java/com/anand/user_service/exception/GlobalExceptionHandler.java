package com.anand.user_service.exception;

import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<String> handleFeignException(FeignException ex){
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Downstream service failed");

    }

    //public ResponseEntity<String> handleOrderException(OrderException)

}
