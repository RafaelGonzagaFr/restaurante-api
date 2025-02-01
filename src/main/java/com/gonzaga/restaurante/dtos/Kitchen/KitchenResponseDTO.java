package com.gonzaga.restaurante.dtos.Kitchen;

import com.gonzaga.restaurante.entities.Kitchen;

public record KitchenResponseDTO (String username, String password) {
    public KitchenResponseDTO(Kitchen kitchen){
        this(kitchen.getUsername(), kitchen.getPassword());
    }
}
