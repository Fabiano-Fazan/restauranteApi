package com.fabianofazan.restauranteapi.controllers;


import com.fabianofazan.restauranteapi.models.dto.ComboDto;
import com.fabianofazan.restauranteapi.models.entities.ComboEntities;
import com.fabianofazan.restauranteapi.service.ComboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/combo")
public class ComboController {

    ComboService comboService;

    @Autowired
    public ComboController(ComboService comboService) {
        this.comboService = comboService;
    }

    @PostMapping
    public ComboEntities create(@RequestBody ComboDto comboDto) {
        return comboService.create(comboDto);
    }

    @GetMapping
    public List<ComboEntities> getAll() {
        return comboService.findAll();
    }

    @GetMapping("/{id}")
    public ComboEntities findById(@PathVariable UUID id ){
        return comboService.findById(id);
    }

    @GetMapping ("/name/{name}")
    public List<ComboEntities> findByName(@PathVariable String name){
        return comboService.findByName(name);
    }


    @PutMapping ("/{id}")
    public ComboEntities update (@PathVariable UUID id, @RequestBody ComboDto comboDto){
        return comboService.update(id, comboDto);
    }

    @DeleteMapping ("/{id}")
    public void delete(@PathVariable UUID id){
        comboService.delete(id);
    }
}
