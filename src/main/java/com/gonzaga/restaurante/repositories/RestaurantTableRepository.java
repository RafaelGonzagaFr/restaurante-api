package com.gonzaga.restaurante.repositories;

import com.gonzaga.restaurante.entities.RestaurantTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantTableRepository extends JpaRepository<RestaurantTable, Long> {
}
