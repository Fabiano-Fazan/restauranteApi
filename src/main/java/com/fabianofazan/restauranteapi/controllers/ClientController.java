package com.fabianofazan.restauranteapi.controllers;


import com.fabianofazan.restauranteapi.models.dto.ClientDto;
import com.fabianofazan.restauranteapi.models.entities.ClientEntities;
import com.fabianofazan.restauranteapi.service.ClientService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientService clientService;

    @Id
    private final UUID id = UUID.randomUUID();

    @PostMapping
    public ClientEntities create(@RequestBody ClientDto clientDto) {
        return clientService.create(clientDto);
    }

    @GetMapping
    public List<ClientEntities> getAll() {
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    public ClientEntities findById(@PathVariable UUID id ){
        return clientService.findById(id);
    }

    @GetMapping ("/name/{name}")
    public List<ClientEntities> findByName(@PathVariable String name){
        return clientService.findByNameContainingIgnoreCase(name);
    }

    @PutMapping ("/{id}")
    public ClientEntities update(@PathVariable UUID id, @RequestBody ClientDto clientDto){
        return clientService.update(id, clientDto);
    }

    @DeleteMapping ("/{id}")
    public void deleteClientEntities(@PathVariable UUID id){
      clientService.deleteClientEntities(id);
    }

}
