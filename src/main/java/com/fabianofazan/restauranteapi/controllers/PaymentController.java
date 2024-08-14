package com.fabianofazan.restauranteapi.controllers;

import com.fabianofazan.restauranteapi.models.dto.PaymentDto;
import com.fabianofazan.restauranteapi.models.entities.PaymentEntities;
import com.fabianofazan.restauranteapi.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public PaymentEntities create(@RequestBody PaymentEntities paymentEntities) {
        return paymentService.create(paymentEntities);
    }

    @GetMapping
    public List<PaymentEntities> getAll() {
        return paymentService.getAll();
    }

    @GetMapping("/{id}")
    public PaymentEntities getById(@PathVariable UUID id) {
        return paymentService.getById(id);
    }

    @PutMapping("/{id}")
    public PaymentEntities update(@PathVariable UUID id, @RequestBody PaymentDto paymentDto) {
        return paymentService.update(id, paymentDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id) {
        paymentService.delete(id);
        return ResponseEntity.ok("Deletar pagamento");
    }
}