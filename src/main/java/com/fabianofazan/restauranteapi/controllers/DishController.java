package com.fabianofazan.restauranteapi.controllers;


import com.fabianofazan.restauranteapi.models.dto.DishDto;
import com.fabianofazan.restauranteapi.models.entities.DishEntities;
import com.fabianofazan.restauranteapi.service.DishService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/dish")
public class DishController {
@Autowired
    DishService dishService;

    @Id
    private final UUID id  = UUID.randomUUID();

    @PostMapping
    public DishEntities create (@RequestBody DishDto dishDto){
        return dishService.create(dishDto);
    }

    @GetMapping
    public List<DishEntities> getAll(){
        return dishService.findAll();
    }

    @GetMapping ("/{id}")
    public DishEntities findById(@PathVariable UUID id){
        return dishService.findById(id);
    }

    @GetMapping ("name/{name}")
    public List<DishEntities> findByName(@PathVariable String name) {
        return dishService.findByNameContainingIgnoreCase(name);
    }

    @PutMapping ("/{id}")
    public DishEntities update (@PathVariable UUID id, @RequestBody DishDto dishDto ){
        return dishService.update(id, dishDto);
    }

    @DeleteMapping ("/{id}")
    public void deleteDishEntities (@PathVariable UUID id) {
        dishService.deleteDishEntities (id);
    }
}
