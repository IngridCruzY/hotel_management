package com.utp.hotelmanagement.service;

import com.utp.hotelmanagement.entity.Reservation;

import java.util.List;

public interface ReservationService {

    Reservation save(Reservation reservation);

    List<Reservation> findAll();

    Reservation findById(Long id);

    Reservation update(Long id, Reservation reservation);

    void deleteById(Long id);

}
