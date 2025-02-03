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
@EqualsAndHashCode(of = "id")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String description;

    @ManyToOne
    @JoinColumn(name = "restaurant_table_id")
    private RestaurantTable restaurantTable;

    private String status;

    public Order(){}

    public Order(OrderRequestDTO orderRequestDTO){
        this.id = orderRequestDTO.id();
        this.description = orderRequestDTO.description();
        this.restaurantTable = orderRequestDTO.restaurantTable();
        this.status = orderRequestDTO.status();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RestaurantTable getRestaurantTable() {
        return restaurantTable;
    }

    public void setRestaurantTable(RestaurantTable restaurantTable) {
        this.restaurantTable = restaurantTable;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
