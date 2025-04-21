package com.ctms.ctms.repositories;

import com.ctms.ctms.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReviewRepo extends JpaRepository<Review,Long> {

    @Query("SELECT p FROM Review p WHERE p.customer.id = :customerId")
    List<Review> findAllByCustomer_id(Long customerId);

    @Query("SELECT p FROM Review p WHERE p.trip.tripId = :tripId")
    List<Review> findAllByTrip_id(Long tripId);

}
