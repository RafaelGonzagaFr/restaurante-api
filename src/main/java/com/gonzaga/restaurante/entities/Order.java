package com.gonzaga.restaurante.entities;

import com.gonzaga.restaurante.dtos.Order.OrderRequestDTO;
import com.gonzaga.restaurante.dtos.Order.OrderResponseDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "order")
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String description;

    private String table;

    private String status;

    public Order(OrderRequestDTO orderRequestDTO){
        this.id = orderRequestDTO.id();
        this.description = orderRequestDTO.description();
        this.table = orderRequestDTO.description();
        this.status = orderRequestDTO.status();
    }
}
