package com.utp.hotelmanagement.service;

import com.utp.hotelmanagement.entity.Client;

import java.util.List;

public interface ClientService {

    Client save(Client client);
    List<Client> findAll();
    Client findById(Long id);
    Client findByDocumentNumber(String documentNumber);
    void deleteById(Long id);
}
