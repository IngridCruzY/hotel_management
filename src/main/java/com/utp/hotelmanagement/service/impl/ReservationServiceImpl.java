package com.utp.hotelmanagement.service.impl;

import com.utp.hotelmanagement.entity.Client;
import com.utp.hotelmanagement.entity.Reservation;
import com.utp.hotelmanagement.entity.Room;
import com.utp.hotelmanagement.repository.ClientRepository;
import com.utp.hotelmanagement.repository.ReservationRepository;
import com.utp.hotelmanagement.repository.RoomRepository;
import com.utp.hotelmanagement.service.ReservationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    private ClientRepository clientRepository;
    private RoomRepository roomRepository;
    private ReservationRepository reservationRepository;

    public ReservationServiceImpl(ClientRepository clientRepository, RoomRepository roomRepository, ReservationRepository reservationRepository) {
        this.clientRepository = clientRepository;
        this.roomRepository = roomRepository;
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Reservation save(Reservation reservation) {

        if (!reservation.getCheckOutDate().isAfter(reservation.getCheckInDate())) {
            throw new RuntimeException("La fecha de salida debe ser posterior a la fecha de entrada");
        }

        Client client = reservation.getClient();

        Client existingClient = clientRepository
                .findById(client.getId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado(a)"));

        Room room = reservation.getRoom();

        Room existingRoom = roomRepository
                .findById(room.getId())
                .orElseThrow(() -> new RuntimeException("La habitación no existe"));

        boolean conflict = reservationRepository.existsReservationConflict(
                existingRoom,
                reservation.getCheckInDate(),
                reservation.getCheckOutDate()
        );

        if (conflict) {
            throw new RuntimeException("La habitación ya está reservada para esas fechas");
        }

        reservation.setClient(existingClient);
        reservation.setRoom(existingRoom);

        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> findAll() {

        return reservationRepository.findAll();
    }

    @Override
    public Reservation findById(Long id) {

        return reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
    }

    @Override
    public Reservation update(Long id, Reservation reservation) {

        Reservation existingReservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));

        if (!reservation.getCheckOutDate().isAfter(reservation.getCheckInDate())) {
            throw new RuntimeException("La fecha de salida debe ser posterior a la fecha de entrada");
        }

        Client existingClient = clientRepository.findById(reservation.getClient().getId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado(a)"));

        Room existingRoom = roomRepository.findById(reservation.getRoom().getId())
                .orElseThrow(() -> new RuntimeException("La habitación no existe"));

        boolean conflict = reservationRepository.existsReservationConflictExcludingCurrent(
                id,
                existingRoom,
                reservation.getCheckInDate(),
                reservation.getCheckOutDate()
        );

        if (conflict) {
            throw new RuntimeException("La habitación ya está reservada para esas fechas");
        }

        existingReservation.setClient(existingClient);
        existingReservation.setRoom(existingRoom);
        existingReservation.setCheckInDate(reservation.getCheckInDate());
        existingReservation.setCheckOutDate(reservation.getCheckOutDate());
        existingReservation.setStatus(reservation.getStatus());

        return reservationRepository.save(existingReservation);
    }

    @Override
    public void deleteById(Long id) {

        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));

        reservationRepository.delete(reservation);
    }
}
