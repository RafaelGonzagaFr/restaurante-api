package com.gonzaga.restaurante.entities;

import com.gonzaga.restaurante.dtos.Waiter.WaiterRequestDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "waiter")
@Table(name = "waiter")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Waiter {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String username;

    private String password;

    public Waiter(WaiterRequestDTO waiterRequestDTO){
        this.id = waiterRequestDTO.id();
        this.username = waiterRequestDTO.username();
        this.password = waiterRequestDTO.password();
    }
}
