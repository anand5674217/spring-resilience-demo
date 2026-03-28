package com.anand.order_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/orders")
public class OrderController {

    @GetMapping("/{userId}")
    public String getOrders(@PathVariable String userId){
        if(Math.random() <0.7){
            throw new RuntimeException("Order Service down");
        }

        return "Orders for user:" + userId;

    }

}
