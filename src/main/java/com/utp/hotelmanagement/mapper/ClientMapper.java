package com.utp.hotelmanagement.mapper;

import com.utp.hotelmanagement.dto.request.ClientRequest;
import com.utp.hotelmanagement.dto.response.ClientResponse;
import com.utp.hotelmanagement.entity.Client;

public class ClientMapper {

    public static Client toEntity(ClientRequest clientRequest) {

        Client client = new Client();

        client.setDocumentNumber(clientRequest.getDocumentNumber());

        client.setFirstName(clientRequest.getFirstName());

        client.setLastName(clientRequest.getLastName());

        client.setEmail(clientRequest.getEmail());

        client.setPhone(clientRequest.getPhone());

        return client;
    }

    public static ClientResponse toResponse(Client client) {

        ClientResponse response = new ClientResponse();

        response.setId(client.getId());

        response.setDocumentNumber(client.getDocumentNumber());

        response.setFirstName(client.getFirstName());

        response.setLastName(client.getLastName());

        response.setEmail(client.getEmail());

        response.setPhone(client.getPhone());

        return response;
    }
}
