package com.ctms.ctms.services;

import com.ctms.ctms.exception.TripNotFoundException;
import com.ctms.ctms.models.Trip;
import com.ctms.ctms.repositories.TripRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class TripService {

    @Autowired
    private TripRepo tripRepo;


    public Trip addTrip(Trip trip) {

        return tripRepo.save(trip);
    }

    public Trip updateTrip(Long id,Trip trip) {
        Trip trip1 = tripRepo.findById(id)
                .orElseThrow(() -> new TripNotFoundException("Trip with ID " + id + " not found"));

        trip1.setItinerary(trip.getItinerary());
        trip1.setAvailableSlots(trip.getAvailableSlots());
        trip1.setPrice(trip.getPrice());
        trip1.setStartTripDate(trip.getStartTripDate());
        trip1.setLastTripDate(trip.getLastTripDate());
        trip1.setLocation(trip.getLocation());

        return tripRepo.save(trip1);
    }

    public String deleteTrip(Long id) {
        Trip trip = tripRepo.findById(id)
                .orElseThrow(() -> new TripNotFoundException("Trip with ID " + id + " not found"));

        tripRepo.delete(trip);
        return "Trip with ID " + id + " deleted successfully";
    }

    public List<Trip> getAllTripsOfAgency(Long id) {
        List<Trip> trips = tripRepo.findAllByAgency_id(id);
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

    public List<Trip> getTripsByTripDate(LocalDate date) {
        List<Trip> trips = tripRepo.findAllByStartTripDate(date);
        if (trips.isEmpty()) {
            throw new TripNotFoundException("No trips found on date: " + date);
        }
        return trips;
    }
}
