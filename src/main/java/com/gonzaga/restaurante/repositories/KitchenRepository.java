package com.gonzaga.restaurante.repositories;

import com.gonzaga.restaurante.entities.Kitchen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KitchenRepository extends JpaRepository<Kitchen, Long> {
}
