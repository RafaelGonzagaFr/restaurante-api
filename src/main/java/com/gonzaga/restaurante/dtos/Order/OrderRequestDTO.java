package com.gonzaga.restaurante.dtos.Order;

import com.gonzaga.restaurante.entities.Order;
import com.gonzaga.restaurante.entities.RestaurantTable;

public record OrderRequestDTO(Long id, String description, RestaurantTable restaurantTable, String status) { }
