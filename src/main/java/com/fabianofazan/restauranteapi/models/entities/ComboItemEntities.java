package com.fabianofazan.restauranteapi.models.entities;

import com.fabianofazan.restauranteapi.models.enums.ItemType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class ComboItemEntities extends MenuItens {

    @Id
    private UUID id;
    private ItemType type;
    private String description;


    public ComboItemEntities() {
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
