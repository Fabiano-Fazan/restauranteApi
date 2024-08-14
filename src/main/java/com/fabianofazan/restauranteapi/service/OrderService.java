package com.fabianofazan.restauranteapi.service;

import com.fabianofazan.restauranteapi.models.dto.OrderDto;
import com.fabianofazan.restauranteapi.models.entities.OrderEntities;
import com.fabianofazan.restauranteapi.models.entities.OrderItemEntities;
import com.fabianofazan.restauranteapi.models.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderEntities create(OrderDto orderDto) {
        OrderEntities order = new OrderEntities();
        order.setId(UUID.randomUUID());
        order.setOrderItemEntities(orderDto.orderItens());
        order.setTotalPrice(orderDto.totalPrice());
        return orderRepository.save(order);
    }

    public OrderEntities findById(UUID id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Pedido não encotrado"));
    }

    public List<OrderEntities> findAll() {
        return orderRepository.findAll();
    }

    public OrderEntities update(UUID id, OrderDto orderDto) {
        OrderEntities order = findById(id);
        order.setOrderItemEntities(orderDto.orderItens());
        return orderRepository.save(order);
    }

    public OrderEntities delete (UUID id) {
        OrderEntities order = findById(id);
        orderRepository.delete(order);
        return order;
    }

    private double cTotalPrice(OrderEntities orderEntities) {
        double total = 0;
        List<OrderItemEntities> items = orderEntities.getOrderItemEntities();
        if (items != null) {
            for (OrderItemEntities item : items) {
                double itemTotal = (item.getPrice() != null ? item.getPrice() : 0) * item.getQuantity();
                if (item.getDiscount() != null && item.getDiscount() > 0) {
                    itemTotal -= item.getDiscount();
                }
                total += itemTotal;
            }
        }
        return total;
    }
}
