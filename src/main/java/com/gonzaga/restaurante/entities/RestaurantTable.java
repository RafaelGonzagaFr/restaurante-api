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
@EqualsAndHashCode(of = "id")
public class RestaurantTable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Long number;

    @OneToMany(mappedBy = "restaurantTable")
    private List<Order> listOfOrders;

    private Double toPay; //Isso daqui possivelmente pode sumir depois, pois cada pedido pode ter um valor total associado

    public RestaurantTable(){}

    public RestaurantTable(RestaurantTableRequestDTO restaurantTableRequestDTO){
        this.number = restaurantTableRequestDTO.number();

        this.listOfOrders = restaurantTableRequestDTO.listOfOrders().stream()
                .map(Order::new)
                .collect(Collectors.toList());

        this.toPay = restaurantTableRequestDTO.toPay();
    }

    public Long getId() {
        return id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public List<Order> getListOfOrders() {
        return listOfOrders;
    }

    public void setListOfOrders(List<Order> listOfOrders) {
        this.listOfOrders = listOfOrders;
    }

    public Double getToPay() {
        return toPay;
    }

    public void setToPay(Double toPay) {
        this.toPay = toPay;
    }
}
