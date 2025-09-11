package com.orderhub.orderservice.service;

import com.orderhub.orderservice.domain.document.Order;
import com.orderhub.orderservice.domain.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }
}
