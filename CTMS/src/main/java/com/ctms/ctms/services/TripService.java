package com.ctms.ctms.services;

import com.ctms.ctms.exception.TripNotFoundException;
import com.ctms.ctms.models.Agency;
import com.ctms.ctms.models.Trip;
import com.ctms.ctms.repositories.TripRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class TripService {
    /*
    @Autowired
    private TripRepo tripRepo;


    public Trip addTrip(String token) {
        Trip trip = new Trip();//agencyService.getCurrentlyLoggedInAgency(token); // will throw if not found

        return tripRepo.save(trip);

    }

    public Trip updateTrip(Long id){
        Trip trip = tripRepo.findById(id)
                .orElseThrow(() -> new TripNotFoundException("Trip with ID " + id + " not found"));



        return tripRepo.save(trip);
    }

    public String deleteTrip(Long id) {
        Trip trip = tripRepo.findById(id)
                .orElseThrow(() -> new TripNotFoundException("Trip with ID " + id + " not found"));

        tripRepo.delete(trip);
        return "Trip with ID " + id + " deleted successfully";
    }

    public List<Trip> getAllTripsOfAgency(Long id) {
        List<Trip> trips = tripRepo.findAllByAgencyId(id);
        if (trips.isEmpty()) {
            throw new TripNotFoundException("No trips found for agency ID: " + id);
        }
        return trips;
    }

    public List<Trip> getAllTrips() {
        List<Trip> trips = tripRepo.findAll();
        if (trips.isEmpty()) {
            throw new TripNotFoundException("No trips available in the system");
        }
        return trips;
    }

    public List<Trip> getTripsWithAvailableSlots(Integer slots) {
        List<Trip> trips = tripRepo.findAllByAvailableSlots(slots);
        if (trips.isEmpty()) {
            throw new TripNotFoundException("No trips found with " + slots + " available slots");
        }
        return trips;
    }

    public List<Trip> getTripsWithLocation(String location) {
        List<Trip> trips = tripRepo.findAllByLocation(location);
        if (trips.isEmpty()) {
            throw new TripNotFoundException("No trips found at location: " + location);
        }
        return trips;
    }

    public List<Trip> getTripsByTripDate(Date date) {
        List<Trip> trips = tripRepo.findAllByTripDate(date);
        if (trips.isEmpty()) {
            throw new TripNotFoundException("No trips found on date: " + date);
        }
        return trips;
    }*/
}
