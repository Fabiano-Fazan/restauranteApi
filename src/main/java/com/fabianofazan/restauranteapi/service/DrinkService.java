package com.fabianofazan.restauranteapi.service;


import com.fabianofazan.restauranteapi.models.dto.DrinkDto;
import com.fabianofazan.restauranteapi.models.entities.DrinkEntities;
import com.fabianofazan.restauranteapi.models.repository.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DrinkService {

    private DrinkRepository drinkRepository;

    @Autowired
    public DrinkService(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    public DrinkEntities create(DrinkDto drinkDto) {
        DrinkEntities drink = new DrinkEntities();
        drink.setId(UUID.randomUUID());
        drink.setName(drinkDto.name());
        drink.setType(drinkDto.type());
        return drinkRepository.save(drink);
    }

    public List<DrinkEntities> findAll() {
        return drinkRepository.findAll();
    }

    public DrinkEntities findById(UUID id) {
        return drinkRepository.findById(id).orElseThrow(()-> new RuntimeException("ID " + id + " not found"));
    }

    public List<DrinkEntities> findByNameContainingIgnoreCase(String name) {
        return drinkRepository.findByNameContainingIgnoreCase(name);
    }

    public DrinkEntities update(UUID id, DrinkDto drinkDto) {
        Optional<DrinkEntities> optionalDrinkEntities = drinkRepository.findById(id);
        DrinkEntities drink = null;
        if (optionalDrinkEntities.isPresent()){
            drink = optionalDrinkEntities.get();
            drink.setName(drinkDto.name());
            drink.setType(drinkDto.type());
            drinkRepository.save(drink);
        } else {
            System.out.println("Bebida não encontrada");
        }
       return drinkRepository.save(drink);
    }
    public void deleteDrinkEntities(UUID id) {
        DrinkEntities drinkEntities = findById(id);
        drinkRepository.delete(drinkEntities);
    }
    
}
