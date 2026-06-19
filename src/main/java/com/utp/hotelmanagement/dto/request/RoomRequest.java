package com.utp.hotelmanagement.dto.request;

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
public class RoomRequest {

    private String roomNumber;

    private Integer floor;

    private Integer capacity;

    private BigDecimal pricePerNight;

    private RoomStatus status;

}
