package com.utp.hotelmanagement.service;

import com.utp.hotelmanagement.entity.Room;
import com.utp.hotelmanagement.entity.enums.RoomStatus;

import java.util.List;

public interface RoomService {

    Room save(Room room);

    List<Room> findAll();

    Room findById(Long id);

    List<Room> findByStatus(RoomStatus roomStatus);

    void deleteById(Long id);
}
