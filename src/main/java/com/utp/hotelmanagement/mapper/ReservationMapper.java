package com.utp.hotelmanagement.mapper;

import com.utp.hotelmanagement.dto.request.ReservationRequest;
import com.utp.hotelmanagement.dto.response.ReservationResponse;
import com.utp.hotelmanagement.entity.Client;
import com.utp.hotelmanagement.entity.Reservation;
import com.utp.hotelmanagement.entity.Room;
import com.utp.hotelmanagement.entity.enums.ReservationStatus;

public class ReservationMapper {

    public static Reservation toEntity(ReservationRequest reservationRequest) {

        Client client = new Client();

        client.setId(reservationRequest.getClientId());

        Room room = new Room();

        room.setId(reservationRequest.getRoomId());

        Reservation reservation = new Reservation();

        reservation.setClient(client);

        reservation.setRoom(room);

        reservation.setCheckInDate(reservationRequest.getCheckInDate());

        reservation.setCheckOutDate(reservationRequest.getCheckOutDate());

        reservation.setStatus(ReservationStatus.RESERVED);

        return reservation;
    }

    public static ReservationResponse toResponse(Reservation reservationResponse) {

        ReservationResponse response = new ReservationResponse();

        response.setId(reservationResponse.getId());

        response.setClientId(reservationResponse.getClient().getId());

        response.setRoomId(reservationResponse.getRoom().getId());

        response.setCheckInDate(reservationResponse.getCheckInDate());

        response.setCheckOutDate(reservationResponse.getCheckOutDate());

        return response;
    }
}
