package com.gonzaga.restaurante.controllers;

import com.gonzaga.restaurante.dtos.Kitchen.KitchenRequestDTO;
import com.gonzaga.restaurante.dtos.Kitchen.KitchenResponseDTO;
import com.gonzaga.restaurante.entities.Kitchen;
import com.gonzaga.restaurante.repositories.KitchenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kitchen")
public class KitchenController {
    @Autowired
    public KitchenRepository kitchenRepository;

    @GetMapping
    public ResponseEntity<List<KitchenResponseDTO>> getAllKitchens(){
        List<KitchenResponseDTO> listOfKitchens = kitchenRepository.findAll().stream().map(KitchenResponseDTO::new).toList();
        return ResponseEntity.ok(listOfKitchens);
    }

    @PostMapping
    public ResponseEntity<KitchenRequestDTO> newKitchen(@RequestBody KitchenRequestDTO kitchenRequestDTO){
        Kitchen kitchen = new Kitchen(kitchenRequestDTO);
        kitchenRepository.save(kitchen);
        return ResponseEntity.ok(kitchenRequestDTO);
    }
}
