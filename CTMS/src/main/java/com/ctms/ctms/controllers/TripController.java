package com.ctms.ctms.controllers;

import com.ctms.ctms.models.Trip;
import com.ctms.ctms.services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
public class TripController {

    @Autowired
    private TripService tripService;

    @PostMapping("/trips")
    public ResponseEntity<Trip> addTripHandler(@RequestBody Trip trip) {
        return new ResponseEntity<>(tripService.addTrip(trip), HttpStatus.CREATED);
    }

    @PutMapping("/trip/{id}")
    public ResponseEntity<Trip> updateTripHandler(@PathVariable Long id, @RequestBody Trip trip) {
        return new ResponseEntity<>(tripService.updateTrip(id, trip), HttpStatus.OK);
    }

    @DeleteMapping("/trip/{id}")
    public ResponseEntity<String> deleteTripHandler(@PathVariable Long id) {
        return new ResponseEntity<>(tripService.deleteTrip(id), HttpStatus.OK);
    }

    @GetMapping("/trip/available/{slots}")
    public ResponseEntity<List<Trip>> getTripsWithAvailableSlotsHandler(@PathVariable Integer slots) {
        return new ResponseEntity<>(tripService.getTripsWithAvailableSlots(slots), HttpStatus.OK);
    }

    @GetMapping("/trip/location/{location}")
    public ResponseEntity<List<Trip>> getTripsWithLocationHandler(@PathVariable String location) {
        return new ResponseEntity<>(tripService.getTripsWithLocation(location), HttpStatus.OK);
    }

    @GetMapping("/trip/date/{date}")
    public ResponseEntity<List<Trip>> getTripsWithTripDateHandler(@PathVariable LocalDate date) {
        return new ResponseEntity<>(tripService.getTripsByTripDate(date), HttpStatus.OK);
    }

    @GetMapping("/trips")
    public ResponseEntity<List<Trip>> getAllTripsHandler() {
        return new ResponseEntity<>(tripService.getAllTrips(), HttpStatus.OK);
    }

    @GetMapping("/agency/trips/{id}")
    public ResponseEntity<List<Trip>> getAllTripsOfAgencyHandler(@PathVariable Long id) {
        return new ResponseEntity<>(tripService.getAllTripsOfAgency(id), HttpStatus.OK);
    }
}
