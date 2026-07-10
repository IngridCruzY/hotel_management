package com.utp.hotelmanagement.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationResponse {

    private Long id;

    private Long clientId;

    private Long roomId;

    private LocalDate checkInDate;

    private LocalDate checkOutDate;

}
