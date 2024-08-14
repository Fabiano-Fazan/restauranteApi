package com.fabianofazan.restauranteapi.models.dto;

import com.fabianofazan.restauranteapi.models.entities.ComboItemEntities;
import com.fabianofazan.restauranteapi.models.enums.ItemType;

import java.util.List;


public record ComboDto(String name, String description, double price, List<ComboItemEntities> itens, ItemType itemType ) {
}


