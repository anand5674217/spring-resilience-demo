package com.anand.user_service.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    @CircuitBreaker(name="demoService", fallbackMethod = "fallback")
    public String callExternal(){

        if(Math.random()<0.7){
            throw new RuntimeException("Boom");

        }

        return "Success Res";

    }


    public String fallback(Exception ex){

        return "Fallback response";

    }
}
