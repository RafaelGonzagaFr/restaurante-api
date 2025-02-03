package com.gonzaga.restaurante.entities;

import com.gonzaga.restaurante.dtos.Kitchen.KitchenRequestDTO;
import com.gonzaga.restaurante.dtos.Kitchen.KitchenResponseDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "kitchen")
@Table(name = "kitchens")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Kitchen {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String username;

    private String password;

    public Kitchen(){}

    public Kitchen(KitchenRequestDTO KitchenRequestDTO){
        this.username = KitchenRequestDTO.username();
        this.password = KitchenRequestDTO.password();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
