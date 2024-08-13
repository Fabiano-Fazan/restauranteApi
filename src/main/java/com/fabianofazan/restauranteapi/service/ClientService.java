package com.fabianofazan.restauranteapi.service;


import com.fabianofazan.restauranteapi.models.dto.ClientDto;
import com.fabianofazan.restauranteapi.models.entities.ClientEntities;
import com.fabianofazan.restauranteapi.models.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class ClientService {

    private ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ClientEntities create(ClientDto clientDto) {
        ClientEntities client = new ClientEntities();
        client.setId(UUID.randomUUID());
        client.setName(clientDto.name());
        client.setDocument(clientDto.document());
        return clientRepository.save(client);
    }

    public List<ClientEntities> findAll() {
        return clientRepository.findAll();
    }

    public ClientEntities findById(UUID id) {
        return clientRepository.findById(id).orElseThrow(() -> new RuntimeException("ID: " + id + " not found"));
    }

    public List<ClientEntities> findByNameContainingIgnoreCase(String name) {
        return clientRepository.findByNameContainingIgnoreCase(name);
    }

    public ClientEntities update( UUID id, ClientDto clientDto) {
        Optional<ClientEntities> optionalClientEntities = clientRepository.findById(id);
        ClientEntities client = null;
        if (optionalClientEntities.isPresent()) {
            client = optionalClientEntities.get();
            client.setName(clientDto.name());
            client.setDocument(clientDto.document());
        } else {
            System.out.println("Error: Client not found");
        }
        return clientRepository.save(client);

    }
   public void deleteClientEntities(UUID id) {
        ClientEntities clientEntities = findById(id);
         clientRepository.delete(clientEntities);
   }

}


