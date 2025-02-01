package com.gonzaga.restaurante.controllers;

import com.gonzaga.restaurante.dtos.Order.OrderRequestDTO;
import com.gonzaga.restaurante.dtos.Order.OrderResponseDTO;
import com.gonzaga.restaurante.dtos.Waiter.WaiterResponseDTO;
import com.gonzaga.restaurante.entities.Order;
import com.gonzaga.restaurante.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    public OrderRepository orderRepository;

    @GetMapping
    public ResponseEntity<List<OrderResponseDTO>> getAllOrders() {
        List<OrderResponseDTO> listOfOrders = orderRepository.findAll().stream().map(OrderResponseDTO::new).toList();
        return ResponseEntity.ok(listOfOrders);
    }

    @PostMapping
    public ResponseEntity<Order> createNewOrder(@RequestBody OrderRequestDTO orderRequestDTO){
        Order order = new Order(orderRequestDTO);
        orderRepository.save(order);
        return ResponseEntity.ok(order);
    }

}
