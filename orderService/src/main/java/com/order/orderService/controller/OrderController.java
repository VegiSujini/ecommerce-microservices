package com.order.orderService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.order.orderService.model.Order;
import com.order.orderService.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    public ResponseEntity<Order> createOrder(@RequestParam Long productId, @RequestParam int quantity) {
        Order order = orderService.createOrder(productId, quantity);
        return ResponseEntity.ok(order);
    }
}
