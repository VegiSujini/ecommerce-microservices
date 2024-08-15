package com.order.orderService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.orderService.model.Order;

public interface orderRepository extends JpaRepository<Order, Long> {

}
