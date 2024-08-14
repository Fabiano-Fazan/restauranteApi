package com.fabianofazan.restauranteapi.models.repository;

import com.fabianofazan.restauranteapi.models.entities.ComboEntities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ComboRepository extends JpaRepository <ComboEntities, UUID> {

    List<ComboEntities> findByNameContainingIgnoreCase(String combo);


}
