package com.gonzaga.restaurante.dtos.RestaurantTable;

import com.gonzaga.restaurante.dtos.Order.OrderRequestDTO;
import com.gonzaga.restaurante.entities.Order;

import java.util.List;

public record RestaurantTableRequestDTO(Long number, List<OrderRequestDTO> listOfOrders, Double toPay) {
}
