package com.fabianofazan.restauranteapi.models.repository;


import com.fabianofazan.restauranteapi.models.entities.ClientEntities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntities, UUID> {
    List<ClientEntities> findByNameContainingIgnoreCase(@Param("name")String name);
    List<ClientEntities> findByDocumentContainingIgnoreCase(@Param("document") String document);
}
