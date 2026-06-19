package com.utp.hotelmanagement.controller;

import com.utp.hotelmanagement.dto.request.RoomRequest;
import com.utp.hotelmanagement.dto.response.RoomResponse;
import com.utp.hotelmanagement.entity.Room;
import com.utp.hotelmanagement.mapper.RoomMapper;
import com.utp.hotelmanagement.service.RoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping
    public RoomResponse save(@RequestBody RoomRequest roomRequest) {

        Room room = RoomMapper.toEntity(roomRequest);

        Room savedRoom = roomService.save(room);

        return RoomMapper.toResponse(savedRoom);
    }

    @GetMapping
    public List<RoomResponse> findAll() {

        return roomService.findAll()
                .stream()
                .map(RoomMapper::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public RoomResponse findById(@PathVariable Long id) {

        Room room = roomService.findById(id);

        return RoomMapper.toResponse(room);
    }

    @DeleteMapping("/{id}")
    public String deletedById(@PathVariable Long id) {

        roomService.deleteById(id);

        return "Room deleted successfully";
    }
}
