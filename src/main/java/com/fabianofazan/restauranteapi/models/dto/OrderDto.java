package com.fabianofazan.restauranteapi.models.dto;

import com.fabianofazan.restauranteapi.models.entities.OrderItemEntities;
import com.fabianofazan.restauranteapi.models.entities.PaymentEntities;
import com.fabianofazan.restauranteapi.models.enums.TypePayment;

import java.util.List;

public record OrderDto (List<OrderItemEntities> orderItens, Double totalPrice, Double discount, PaymentEntities payment, TypePayment typePayment) {
}
