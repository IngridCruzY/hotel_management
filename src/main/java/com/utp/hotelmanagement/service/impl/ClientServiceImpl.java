package com.utp.hotelmanagement.service.impl;

import com.utp.hotelmanagement.entity.Client;
import com.utp.hotelmanagement.repository.ClientRepository;
import com.utp.hotelmanagement.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client save(Client client) {
        if (clientRepository.findByDocumentNumber(client.getDocumentNumber()).isPresent()) {
            throw new RuntimeException("El número de documento ya existe");
        }
        return clientRepository.save(client);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado(a)"));
    }

    @Override
    public Client findByDocumentNumber(String documentNumber) {
        return clientRepository.findByDocumentNumber(documentNumber)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado(a)"));
    }

    @Override
    public void deleteById(Long id) {
        Client client = findById(id);
        clientRepository.delete(client);
    }
}
