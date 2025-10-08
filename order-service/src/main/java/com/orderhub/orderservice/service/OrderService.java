package com.orderhub.orderservice.service;

import com.orderhub.orderservice.domain.document.Order;
import com.orderhub.orderservice.domain.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final RestTemplate restTemplate;

    public OrderService(OrderRepository orderRepository, RestTemplate restTemplate) {
        this.orderRepository = orderRepository;
        this.restTemplate = restTemplate;
    }

    public Order createOrder(Order order) {
        String userServiceUrl = "http://USER-SERVICE/api/v1/users/" + order.getUserId();

        try {
            restTemplate.getForObject(userServiceUrl, Object.class);
        } catch (Exception e) {
            throw new RuntimeException("User not found with id: " + order.getUserId());
        }

        return orderRepository.save(order);
    }
}
