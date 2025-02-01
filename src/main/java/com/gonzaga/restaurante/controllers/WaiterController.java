package com.gonzaga.restaurante.controllers;

import com.gonzaga.restaurante.dtos.Waiter.WaiterRequestDTO;
import com.gonzaga.restaurante.dtos.Waiter.WaiterResponseDTO;
import com.gonzaga.restaurante.entities.Waiter;
import com.gonzaga.restaurante.repositories.WaiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/waiter")
public class WaiterController {
    @Autowired
    public WaiterRepository waiterRepository;

    @GetMapping
    public ResponseEntity<List<WaiterResponseDTO>> getAllWaiters(){
        List<WaiterResponseDTO> listOfWaiters = waiterRepository.findAll().stream().map(WaiterResponseDTO::new).toList();
        return ResponseEntity.ok(listOfWaiters);
    }

    @PostMapping
    public ResponseEntity<Waiter> createNewWaiter(@RequestBody WaiterRequestDTO waiterRequestDTO){
        Waiter waiter = new Waiter(waiterRequestDTO);
        waiterRepository.save(waiter);
        return ResponseEntity.ok(waiter);
    }
}
