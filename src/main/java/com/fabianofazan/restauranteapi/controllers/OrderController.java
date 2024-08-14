package com.fabianofazan.restauranteapi.controllers;

import com.fabianofazan.restauranteapi.models.dto.OrderDto;
import com.fabianofazan.restauranteapi.models.entities.OrderEntities;
import com.fabianofazan.restauranteapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public OrderEntities create(@RequestBody OrderDto orderDto){
        return orderService.create(orderDto);
    }

    @GetMapping
    public List<OrderEntities> findAll() {
        return orderService.findAll();
    }

    @GetMapping("/{id}")
    public OrderEntities findById(@PathVariable UUID id){
        return orderService.findById(id);
    }

    @PutMapping ("/{id}")
    public OrderEntities update(@PathVariable UUID id, @RequestBody OrderDto orderDto){
        return orderService.update(id, orderDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete (@PathVariable UUID id) {
        orderService.delete(id);
        return ResponseEntity.ok("Deletar pedido");
    }
}

