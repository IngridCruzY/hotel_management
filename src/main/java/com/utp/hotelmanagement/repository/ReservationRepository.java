package com.utp.hotelmanagement.repository;

import com.utp.hotelmanagement.entity.Reservation;
import com.utp.hotelmanagement.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("""
        SELECT COUNT(r) > 0
        FROM Reservation r
        WHERE r.room = :room
          AND r.checkInDate < :checkOutDate
          AND r.checkOutDate > :checkInDate
    """)
    boolean existsReservationConflict(
            @Param("room") Room room,
            @Param("checkInDate") LocalDate checkInDate,
            @Param("checkOutDate") LocalDate checkOutDate);

    @Query("""
        SELECT COUNT(r) > 0
        FROM Reservation r
        WHERE r.room = :room
          AND r.id <> :reservationId
          AND r.checkInDate < :checkOutDate
          AND r.checkOutDate > :checkInDate
    """)
    boolean existsReservationConflictExcludingCurrent(
            @Param("reservationId") Long reservationId,
            @Param("room") Room room,
            @Param("checkInDate") LocalDate checkInDate,
            @Param("checkOutDate") LocalDate checkOutDate);
}
