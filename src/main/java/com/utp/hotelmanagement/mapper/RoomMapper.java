package com.utp.hotelmanagement.mapper;

import com.utp.hotelmanagement.dto.request.RoomRequest;
import com.utp.hotelmanagement.dto.response.RoomResponse;
import com.utp.hotelmanagement.entity.Room;

public class RoomMapper {

    public static Room toEntity(RoomRequest roomRequest) {

        Room room = new Room();

        room.setRoomNumber(roomRequest.getRoomNumber());

        room.setFloor(roomRequest.getFloor());

        room.setCapacity(roomRequest.getCapacity());

        room.setPricePerNight(roomRequest.getPricePerNight());

        room.setStatus(roomRequest.getStatus());

        return room;
    }

    public static RoomResponse toResponse(Room room) {

        RoomResponse response = new RoomResponse();

        response.setId(room.getId());

        response.setRoomNumber(room.getRoomNumber());

        response.setFloor(room.getFloor());

        response.setCapacity(room.getCapacity());

        response.setPricePerNight(room.getPricePerNight());

        response.setStatus(room.getStatus());

        return response;
    }
}
