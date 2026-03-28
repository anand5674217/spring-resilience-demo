package com.anand.user_service.service;

import com.anand.user_service.client.MyLogger;
import com.anand.user_service.client.OrderClient;
import com.anand.user_service.controller.UserController;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    OrderClient orderClient;

    @MyLogger
    @CircuitBreaker(name="orderService",fallbackMethod = "fallback")
    @Retry(name = "orderService")
    public String getUserOrders(String userId){
        return orderClient.getOrders(userId);
    }

    public String fallback(String userId,Exception ex){
        return "Fallback: Order service is down";
    }


}
