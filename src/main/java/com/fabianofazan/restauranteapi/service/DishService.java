package com.fabianofazan.restauranteapi.service;


import com.fabianofazan.restauranteapi.models.dto.DishDto;
import com.fabianofazan.restauranteapi.models.entities.DishEntities;
import com.fabianofazan.restauranteapi.models.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class DishService {

    private final DishRepository dishRepository;

    @Autowired
    public DishService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    public DishEntities create (DishDto dishDto){
        DishEntities dish = new DishEntities();
        dish.setId(UUID.randomUUID());
        dish.setName(dishDto.name());
        dish.setDescription(dishDto.description());
        return dishRepository.save(dish);
    }

    public List<DishEntities> findAll(){
        return dishRepository.findAll();
    }

    public DishEntities findById(UUID id){
        return dishRepository.findById(id).orElseThrow(()-> new RuntimeException("ID" + id + "não encontrado"));
    }

    public List<DishEntities> findByName(String name){
        return dishRepository.findByNameContainingIgnoreCase(name);

    }

    public DishEntities update(UUID id, DishDto dishDto) {
        Optional <DishEntities> optionalDishEntities = dishRepository.findById(id);
        DishEntities dish = null;
        if (optionalDishEntities.isPresent()) {
            dish = optionalDishEntities.get();
            dish.setName(dishDto.name());
            dish.setDescription(dishDto.description());
            dishRepository.save (dish);
        }else{
            System.out.println("Prato não encontrado");
        }
        return dishRepository.save(dish);
    }
    public void deleteDishEntities(UUID id){
        DishEntities dishEntities = findById (id);
        dishRepository.delete(dishEntities);
    }

}
