package com.anand.order_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(OrderServiceException.class)
    public ResponseEntity<ErrorResponse> handleOrderException(OrderServiceException ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
               // "Something went worng "+ ex.getMessage()
                new ErrorResponse("Failure",500, LocalDateTime.now())
        );
    }
}
