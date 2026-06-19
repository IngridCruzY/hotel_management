package com.utp.hotelmanagement.repository;

import com.utp.hotelmanagement.entity.Room;
import com.utp.hotelmanagement.entity.enums.RoomStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {

    List<Room> findByStatus(RoomStatus roomStatus);

    boolean existsByRoomNumber(String roomNumber);
}
