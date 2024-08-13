package com.fabianofazan.restauranteapi.models.repository;

import com.fabianofazan.restauranteapi.models.entities.DishEntities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DishRepository extends JpaRepository<DishEntities, UUID> {
    List<DishEntities> findByNameContainingIgnoreCase(@Param("name")String name);
}
