package com.orderhub.orderservice.domain.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "orders")
public class Order {

    @Id
    private String id;

    private Long userId;
    private List<String> items; // A simple list of item descriptions for now
    private String status;
    private LocalDateTime createdAt;

    // --- Constructors ---

    public Order() {
        this.createdAt = LocalDateTime.now();
        this.status = "PENDING";
    }

    public Order(Long userId, List<String> items) {
        this.userId = userId;
        this.items = items;
        this.createdAt = LocalDateTime.now();
        this.status = "PENDING";
    }

    // --- Getters and Setters ---

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
