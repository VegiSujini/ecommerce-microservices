package com.order.orderService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestParam Long productId, @RequestParam int quantity) {
        Order order = orderService.createOrder(productId, quantity);
        if (order != null)
            return ResponseEntity.ok(order);
        else
            return ResponseEntity.status(500).body(null);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getOrder() {
        List<Order> orders = orderService.getOrders();
        return ResponseEntity.ok(orders);
    }
}
