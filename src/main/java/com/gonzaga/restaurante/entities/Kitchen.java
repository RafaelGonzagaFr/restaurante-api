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
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Kitchen {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String username;

    private String password;

    public Kitchen(KitchenRequestDTO KitchenRequestDTO){
        this.username = KitchenRequestDTO.username();
        this.password = KitchenRequestDTO.password();
    }
}
