package com.anand.order_service.exception;

public class OrderServiceException extends RuntimeException{

    public OrderServiceException(String message){
        super(message);
    }
}
