package com.utp.hotelmanagement.controller;

import com.utp.hotelmanagement.dto.request.ReservationRequest;
import com.utp.hotelmanagement.dto.response.ReservationResponse;
import com.utp.hotelmanagement.entity.Reservation;
import com.utp.hotelmanagement.mapper.ReservationMapper;
import com.utp.hotelmanagement.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public ReservationResponse save(@RequestBody ReservationRequest request) {

        Reservation reservation = ReservationMapper.toEntity(request);

        Reservation savedReservation = reservationService.save(reservation);

        return ReservationMapper.toResponse(savedReservation);
    }

    @GetMapping
    public List<ReservationResponse> findAll() {

        return reservationService.findAll()
                .stream()
                .map(ReservationMapper::toResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ReservationResponse findById(@PathVariable Long id) {

        Reservation reservation = reservationService.findById(id);
        return ReservationMapper.toResponse(reservation);
    }

    @PutMapping("/{id}")
    public ReservationResponse update(
            @PathVariable Long id,
            @RequestBody ReservationRequest request) {

        Reservation reservation = ReservationMapper.toEntity(request);

        Reservation updatedReservation = reservationService.update(id, reservation);

        return ReservationMapper.toResponse(updatedReservation);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id) {

        reservationService.deleteById(id);

        return "Reserva eliminada correctamente";
    }

}
