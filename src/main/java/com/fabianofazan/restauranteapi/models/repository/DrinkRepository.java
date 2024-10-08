package com.fabianofazan.restauranteapi.models.repository;



import com.fabianofazan.restauranteapi.models.entities.DrinkEntities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DrinkRepository extends JpaRepository<DrinkEntities, UUID> {
    List<DrinkEntities> findByNameContainingIgnoreCase(@Param("name")String name);
}

