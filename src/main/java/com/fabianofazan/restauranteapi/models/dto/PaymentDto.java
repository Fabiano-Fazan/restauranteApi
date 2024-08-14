package com.fabianofazan.restauranteapi.models.dto;

import com.fabianofazan.restauranteapi.models.enums.TypePayment;

import java.util.UUID;

public record PaymentDto(UUID id, Double amount, TypePayment typePayment, Double value) {
}
