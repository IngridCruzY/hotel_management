package com.utp.hotelmanagement.service.impl;

import com.utp.hotelmanagement.entity.Room;
import com.utp.hotelmanagement.entity.enums.RoomStatus;
import com.utp.hotelmanagement.repository.RoomRepository;
import com.utp.hotelmanagement.service.RoomService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public Room save(Room room) {

        if (roomRepository.existsByRoomNumber(room.getRoomNumber())) {

            throw new RuntimeException("Room already exists");
        }
        return roomRepository.save(room);
    }

    @Override
    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    @Override
    public Room findById(Long id) {
        return roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found"));
    }

    @Override
    public List<Room> findByStatus(RoomStatus roomStatus) {
        return roomRepository.findByStatus(roomStatus);
    }

    @Override
    public void deleteById(Long id) {
        Room room = findById(id);
        roomRepository.delete(room);
    }
}
