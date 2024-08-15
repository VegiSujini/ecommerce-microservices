package com.order.orderService.service;

import org.springframework.beans.factory.annotation.Autowired;
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

    public Order createOrder(Long productId, int quantity) {
        Product product = productClient.getProductById(productId);
        Order order = new Order();
        order.setProductId(productId);
        order.setQuantity(quantity);
        order.setTotalPrice(product.getPrice() * quantity);
        return orderRepository.save(order);
    }
}
