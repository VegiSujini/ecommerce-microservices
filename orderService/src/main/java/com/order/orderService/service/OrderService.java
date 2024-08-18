package com.order.orderService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;

import com.order.orderService.client.ProductClient;
import com.order.orderService.model.Order;
import com.order.orderService.model.Product;
import com.order.orderService.repository.OrderRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductClient productClient;

    @Autowired
    private CircuitBreakerFactory<?, ?> circuitBreakerFactory;

    public Order createOrder(Long productId, int quantity) {
        return circuitBreakerFactory.create("productService").run(() -> {
            Product product = productClient.getProductById(productId);
            Order order = new Order();
            order.setProductId(productId);
            order.setQuantity(quantity);
            order.setTotalPrice(product.getPrice() * quantity);
            return orderRepository.save(order);

        }, throwable -> {
            System.out.println("Fallback: Unable to create order");
            return null;
        });
    }

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }
}
