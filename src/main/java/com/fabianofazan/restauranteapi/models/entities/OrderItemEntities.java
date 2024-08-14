package com.fabianofazan.restauranteapi.models.entities;

import com.fabianofazan.restauranteapi.models.enums.ItemType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.UUID;

@Entity
public class OrderItemEntities {

    @Id
    private UUID id;
    private int quantity;
    private UUID itemId;
    private String name;
    private Double price;
    private Double discount;
    private ItemType itemType;

    @ManyToOne
    private OrderEntities orderEntities;
    @ManyToOne
    private PaymentEntities paymentEntities;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public UUID getItemId() {
        return itemId;
    }

    public void setItemId(UUID itemId) {
        this.itemId = itemId;
    }
    public OrderEntities getOrderEntities() {
        return orderEntities;
    }
    public void setOrderEntities(OrderEntities orderEntities) {
        this.orderEntities = orderEntities;
    }

    public PaymentEntities getPaymentEntities(PaymentEntities paymentEntities) {
        return paymentEntities;
    }

    public void setPaymentEntities(PaymentEntities paymentEntities) {
        this.paymentEntities = paymentEntities;
    }

}
