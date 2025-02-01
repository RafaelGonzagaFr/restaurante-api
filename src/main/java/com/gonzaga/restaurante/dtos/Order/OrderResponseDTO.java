package com.gonzaga.restaurante.dtos.Order;

import com.gonzaga.restaurante.entities.Order;
import com.gonzaga.restaurante.entities.Waiter;
import com.gonzaga.restaurante.repositories.OrderRepository;

public record OrderResponseDTO(String description, String table, String status) {
    public OrderResponseDTO(Order order){
        this(order.getDescription(), order.getTable(), order.getStatus());
    }

}
