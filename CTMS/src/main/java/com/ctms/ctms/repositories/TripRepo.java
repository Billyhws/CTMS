package com.ctms.ctms.repositories;

import com.ctms.ctms.models.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface TripRepo extends JpaRepository<Trip,Long> {

    List<Trip> findAllByAvailableSlots(Integer availableSlots);

    List<Trip> findAllByLocation(String location);

    List<Trip> findAllByTripDate(LocalDate tripDate);

    @Query("SELECT p FROM Trip p WHERE p.agency_id = :id")
    List <Trip> findAllByAgency_id(Long id);
}

