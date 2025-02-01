package com.gonzaga.restaurante.repositories;

import com.gonzaga.restaurante.entities.Waiter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WaiterRepository extends JpaRepository<Waiter, Long> {
}
