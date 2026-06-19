package com.utp.hotelmanagement.dto.response;

import com.utp.hotelmanagement.entity.enums.RoomStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomResponse {

    private Long id;

    private String roomNumber;

    private Integer floor;

    private Integer capacity;

    private BigDecimal pricePerNight;

    private RoomStatus status;

}
