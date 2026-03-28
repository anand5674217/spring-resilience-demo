package com.anand.user_service.controller;

import com.anand.user_service.service.UserService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{userId}/orders")
    public String getOrders(@PathVariable String userId){
        return userService.getUserOrders(userId);
    }

    @Aspect
    @Component
    public static class MyLoggerAspect{

        @Around("@annotation(com.anand.user_service.client.MyLogger)")
        public Object log(ProceedingJoinPoint joinPoint) throws Throwable{

            System.out.println("Before method: "+ joinPoint.getSignature().getName());

            Object result=joinPoint.proceed();

            System.out.println("After method");

            return result;
        }
    }
}
