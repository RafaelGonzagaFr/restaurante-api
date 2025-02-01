package com.gonzaga.restaurante.controllers;

import com.gonzaga.restaurante.dtos.RestaurantTable.RestaurantTableRequestDTO;
import com.gonzaga.restaurante.dtos.RestaurantTable.RestaurantTableResponseDTO;
import com.gonzaga.restaurante.entities.Order;
import com.gonzaga.restaurante.entities.RestaurantTable;
import com.gonzaga.restaurante.repositories.RestaurantTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/restauranttable")
public class RestaurantTableController {
    @Autowired
    public RestaurantTableRepository restaurantTableRepository;

    @GetMapping
    public ResponseEntity<List<RestaurantTableResponseDTO>> getAllRestaurantTables(){
        List<RestaurantTableResponseDTO> listOfRestaurantTables = restaurantTableRepository.findAll().stream().map(RestaurantTableResponseDTO::new).toList();
        return ResponseEntity.ok(listOfRestaurantTables);
    }

    @PostMapping
    public ResponseEntity<RestaurantTableRequestDTO> newTable(@RequestBody RestaurantTableRequestDTO restaurantTableRequestDTO){
        RestaurantTable restaurantTable = new RestaurantTable(restaurantTableRequestDTO);
        restaurantTableRepository.save(restaurantTable);
        return ResponseEntity.ok(restaurantTableRequestDTO);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateRestaurantTable(@PathVariable Long id, @RequestBody RestaurantTableRequestDTO restaurantTableRequestDTO){
        Optional<RestaurantTable> restaurantTableById = restaurantTableRepository.findById(id);
        if(restaurantTableById.isPresent()){
            RestaurantTable restaurantTable = restaurantTableById.get();
            restaurantTable.setNumber(restaurantTableRequestDTO.number());
            restaurantTable.setToPay(restaurantTableRequestDTO.toPay());
            restaurantTable.setListOfOrders(restaurantTableRequestDTO.listOfOrders().stream()
                    .map(Order::new)
                    .collect(Collectors.toList()));

            restaurantTableRepository.save(restaurantTable);
            return ResponseEntity.ok("modified");
        }
        return ResponseEntity.ok("Not found");
    }
}
