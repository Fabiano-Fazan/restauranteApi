package com.fabianofazan.restauranteapi.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;
import java.util.UUID;

@Entity
public class OrderEntities {

    @Id
    private UUID id;
    private Double totalPrice;

    @OneToMany (mappedBy = "orderEntities")
    private List<OrderItemEntities> orderItemEntities;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<OrderItemEntities> getOrderItemEntities() {
        return orderItemEntities;
    }

    public void setOrderItemEntities(List<OrderItemEntities> orderItemEntities) {
        this.orderItemEntities = orderItemEntities;
    }
}
