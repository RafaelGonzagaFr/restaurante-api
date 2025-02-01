package com.gonzaga.restaurante.dtos.RestaurantTable;

import com.gonzaga.restaurante.dtos.Order.OrderResponseDTO;
import com.gonzaga.restaurante.entities.Order;
import com.gonzaga.restaurante.entities.RestaurantTable;

import java.util.List;
import java.util.stream.Collectors;

public record RestaurantTableResponseDTO(Long number, List<OrderResponseDTO> listOfOrders, Double toPay) {
    public RestaurantTableResponseDTO(RestaurantTable restaurantTable){
        this(restaurantTable.getNumber(),
                restaurantTable.getListOfOrders().stream()
                        .map(OrderResponseDTO::new)
                        .collect(Collectors.toList()),
                restaurantTable.getToPay());
    }
}
