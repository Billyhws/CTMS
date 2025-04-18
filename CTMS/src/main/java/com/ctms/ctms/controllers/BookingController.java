package com.ctms.ctms.controllers;

import com.ctms.ctms.models.Booking;
import com.ctms.ctms.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/booking")
    public ResponseEntity<Booking> addBookHandler(@RequestBody Booking book) {
        return new ResponseEntity<>(bookingService.addBook(book), HttpStatus.CREATED);
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<String> deleteBookHandler(@PathVariable Long id) {
        return new ResponseEntity<>(bookingService.deleteBook(id), HttpStatus.OK);
    }

    @GetMapping("/boook/{id}")
    public ResponseEntity<Booking> getBookHandler(@PathVariable Long id){
        return new ResponseEntity<>(bookingService.getBook(id), HttpStatus.OK);
    }

    @PutMapping("/book/{id}")
    public ResponseEntity<Booking> updateReviewHandler(@PathVariable("id") Long id , @RequestBody Booking book) {
        return new ResponseEntity<>(bookingService.updateBook(id,book), HttpStatus.OK);
    }
    @PutMapping("/book/{id}")
    public ResponseEntity<Booking> checkReviewHandler(@PathVariable("id") Long id , @RequestBody BookingStatus book) {
        return new ResponseEntity<>(bookingService.checkBook(id,book), HttpStatus.OK);
    }

    @GetMapping("/booking/{tripId}")
    public ResponseEntity<List<Booking>> getAllBooksOfTripHandler(@PathVariable Long tripId){
        return new ResponseEntity<>(bookingService.getAllBooksOfTrip(tripId), HttpStatus.OK);
    }

    @GetMapping("/boooking/{customerId}")
    public ResponseEntity<List<Booking>> getAllBooksOfCustomerHandler(@PathVariable Long customerId){
        return new ResponseEntity<>(bookingService.getAllBooksOfCustomer(customerId), HttpStatus.OK);
    }
}
