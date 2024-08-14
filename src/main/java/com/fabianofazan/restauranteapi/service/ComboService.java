package com.fabianofazan.restauranteapi.service;


import com.fabianofazan.restauranteapi.models.dto.ComboDto;
import com.fabianofazan.restauranteapi.models.entities.ComboEntities;
import com.fabianofazan.restauranteapi.models.repository.ComboRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ComboService {

    private final ComboRepository comboRepository;

    @Autowired
    public ComboService(ComboRepository comboRepository) {
        this.comboRepository = comboRepository;
    }

    public ComboEntities create (ComboDto comboDto){
        ComboEntities combo = new ComboEntities();
        combo.setId(UUID.randomUUID());
        combo.setName(comboDto.name());
        combo.setDescription(comboDto.description());
        return comboRepository.save(combo);
    }

    public ComboEntities findById(UUID id) {
        return comboRepository.findById(id).orElseThrow(() -> new RuntimeException("Combo não encontrado"));
    }

    public List<ComboEntities> findAll() {
        return comboRepository.findAll();
    }

    public List<ComboEntities> findByName(String name) {
        return comboRepository.findByNameContainingIgnoreCase(name);
    }

    public ComboEntities update(UUID id, ComboDto comboDto) {
        Optional<ComboEntities> optionalComboEntities = comboRepository.findById(id);
        ComboEntities combo = null;
        if (optionalComboEntities.isPresent()) {
            combo = optionalComboEntities.get();
            combo.setName(comboDto.name());
            combo.setDescription(comboDto.description());
            combo.setItens(comboDto.itens());
        }
        return comboRepository.save(combo);
    }
    public void delete(UUID id) {
        ComboEntities combo = findById(id);
        comboRepository.delete(combo);
    }
}
