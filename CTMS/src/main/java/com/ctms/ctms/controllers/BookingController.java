package com.ctms.ctms.controllers;

import com.ctms.ctms.models.Booking;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class BookingController {

    /*
    @PostMapping("/booking")
    public ResponseEntity<Booking> addBookHandler(@PathVariable Long tripId , @RequestBody Booking book) {
        return new ResponseEntity<>(bookingService.addBook(tripId,book), HttpStatus.CREATED);
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<String> deleteBookHandler(@PathVariable Long id) {
        return new ResponseEntity<>(bookingService.deleteBook(id), HttpStatus.OK);
    }

    @GetMapping("/boook/{id}")
    public ResponseEntity<Booking> getBookHandler(@PathVariable Long id){
        return new ResponseEntity<>(bookingService.getBook(id), HttpStatus.OK);
    }

    @GetMapping("/booking")
    public ResponseEntity<List<Booking>> getAllBooksOfTripHandler(@PathVariable Long tripId){
        return new ResponseEntity<>(bookingService.getAllBooksOfTrip(tripId), HttpStatus.OK);
    }

    @GetMapping("/boooking")
    public ResponseEntity<List<Booking>> getAllBooksOfCustomerHandler(@PathVariable Long tripId){
        return new ResponseEntity<>(bookingService.getAllBooksOfCustomer(tripId), HttpStatus.OK);
    }



    @PutMapping("/")
    public ResponseEntity<Booking> checkBookHandler(@PathVariable("id") Long id) {
        return new ResponseEntity<>(bookingService.checkBook(id), HttpStatus.OK);
    }

    */
}
