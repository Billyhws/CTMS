package com.ctms.ctms.repositories;

import com.ctms.ctms.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepo extends JpaRepository<Booking,Long> {

    @Query("SELECT p FROM Booking p WHERE p.customer.id = :customerId")
    List<Booking> findAllByCustomer_id(Long customerId);

    @Query("SELECT p FROM Booking p WHERE p.trip.tripId = :tripId")
    List<Booking> findAllByTrip_id(Long tripId);

}
