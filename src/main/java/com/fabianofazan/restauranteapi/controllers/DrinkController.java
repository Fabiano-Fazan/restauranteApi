package com.fabianofazan.restauranteapi.controllers;


import com.fabianofazan.restauranteapi.models.dto.DrinkDto;
import com.fabianofazan.restauranteapi.models.entities.DrinkEntities;
import com.fabianofazan.restauranteapi.service.DrinkService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/drink")
public class DrinkController {
    @Autowired
    DrinkService drinkService;

    @Id
    private final UUID id = UUID.randomUUID();


    @PostMapping
    public DrinkEntities create(@RequestBody DrinkDto drinkDto) {
        return drinkService.create(drinkDto);
    }

    @GetMapping
    public List<DrinkEntities> getAll() {
        return drinkService.findAll();
    }

    @GetMapping("/{id}")
    public DrinkEntities findById(@PathVariable UUID id ){
        return drinkService.findById(id);
    }

    @GetMapping ("/name/{name}")
    public List<DrinkEntities> findByName(@PathVariable String name){
        return drinkService.findByNameContainingIgnoreCase(name);
    }

    @PutMapping ("/{id}")
    public DrinkEntities update(@PathVariable UUID id, @RequestBody DrinkDto drinkDto){
        return drinkService.update(id, drinkDto);
    }

    @DeleteMapping ("/{id}")
    public void deleteDrinkEntities(@PathVariable UUID id){
        drinkService.deleteDrinkEntities(id);
    }

}
