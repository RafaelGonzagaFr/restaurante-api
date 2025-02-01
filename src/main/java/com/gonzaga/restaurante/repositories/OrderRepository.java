package com.gonzaga.restaurante.repositories;

import com.gonzaga.restaurante.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
