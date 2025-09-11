package com.orderhub.orderservice.domain.repository;

import com.orderhub.orderservice.domain.document.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
}
