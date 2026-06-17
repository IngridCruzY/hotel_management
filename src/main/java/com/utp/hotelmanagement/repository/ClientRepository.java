package com.utp.hotelmanagement.repository;

import com.utp.hotelmanagement.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByDocumentNumber(String documentNumber);
}
