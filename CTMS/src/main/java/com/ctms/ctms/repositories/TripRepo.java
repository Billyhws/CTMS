package com.ctms.ctms.repositories;

import com.ctms.ctms.models.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface TripRepo extends JpaRepository<Trip,Long> {


}

