package com.fabianofazan.restauranteapi.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;
import java.util.UUID;

@Entity
public class ComboEntities {

    @Id
    private UUID id;
    private String name;
    private String description;

    @OneToMany
    private List<ComboItemEntities> itens;

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public List<ComboItemEntities> getItens() {
        return itens;
    }
    public void setItens(List<ComboItemEntities> itens) {
        this.itens = itens;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

