package com.utp.hotelmanagement.controller;

import com.utp.hotelmanagement.dto.request.ClientRequest;
import com.utp.hotelmanagement.dto.response.ClientResponse;
import com.utp.hotelmanagement.entity.Client;
import com.utp.hotelmanagement.mapper.ClientMapper;
import com.utp.hotelmanagement.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ClientResponse save(@RequestBody ClientRequest request) {

        Client client = ClientMapper.toEntity(request);

        Client savedClient = clientService.save(client);

        return ClientMapper.toResponse(savedClient);

    }

    @GetMapping
    public List<ClientResponse> findAll() {
        return clientService.findAll()
                .stream()
                .map(ClientMapper::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public ClientResponse findById(@PathVariable Long id) {
        Client client = clientService.findById(id);
        return ClientMapper.toResponse(client);
    }

    @DeleteMapping("/{id}")
    public Map<String, String> deleteById(@PathVariable Long id) {
        clientService.deleteById(id);
        return Map.of("message", "Client deleted successfully");
    }
}
