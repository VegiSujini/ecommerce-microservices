package com.order.orderService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.orderService.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
