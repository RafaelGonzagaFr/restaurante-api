package com.gonzaga.restaurante.dtos.Waiter;

import com.gonzaga.restaurante.entities.Waiter;

public record WaiterResponseDTO(String username, String password) {
    public WaiterResponseDTO(Waiter waiter){
        this(waiter.getUsername(), waiter.getPassword());
    }
}
