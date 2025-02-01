package com.gonzaga.restaurante.entities;

import com.gonzaga.restaurante.dtos.Order.OrderRequestDTO;
import com.gonzaga.restaurante.dtos.RestaurantTable.RestaurantTableRequestDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity(name = "restaurantTable")
@Table(name = "restaurant_tables")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class RestaurantTable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Long number;

    @OneToMany(mappedBy = "restaurantTable")
    private List<Order> listOfOrders;

    private Double toPay;

    public RestaurantTable(RestaurantTableRequestDTO restaurantTableRequestDTO){
        this.number = restaurantTableRequestDTO.number();

        this.listOfOrders = restaurantTableRequestDTO.listOfOrders().stream()
                .map(Order::new)
                .collect(Collectors.toList());

        this.toPay = restaurantTableRequestDTO.toPay();
    }

}
