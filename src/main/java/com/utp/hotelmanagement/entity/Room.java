package com.utp.hotelmanagement.entity;

import com.utp.hotelmanagement.entity.enums.RoomStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "rooms")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomNumber;

    private Integer floor;

    private Integer capacity;

    private BigDecimal pricePerNight;

    @Enumerated(EnumType.STRING)
    private RoomStatus status;
}
