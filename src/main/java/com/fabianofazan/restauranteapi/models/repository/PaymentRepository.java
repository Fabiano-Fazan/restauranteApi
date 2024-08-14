package com.fabianofazan.restauranteapi.models.repository;

import com.fabianofazan.restauranteapi.models.entities.PaymentEntities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntities, UUID> {
    Optional<PaymentEntities> findById(@Param("id")UUID id);
}
