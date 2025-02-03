package com.gonzaga.restaurante.entities;

import com.gonzaga.restaurante.dtos.Waiter.WaiterRequestDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "waiter")
@Table(name = "waiter")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Waiter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    public Waiter(){}

    public Waiter(WaiterRequestDTO waiterRequestDTO){
        this.id = waiterRequestDTO.id();
        this.username = waiterRequestDTO.username();
        this.password = waiterRequestDTO.password();
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
