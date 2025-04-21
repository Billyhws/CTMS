package com.ctms.ctms.controllers;

import com.ctms.ctms.models.Booking;
import com.ctms.ctms.models.BookingStatus;
import com.ctms.ctms.models.Customer;
import com.ctms.ctms.repositories.BookingRepo;
import com.ctms.ctms.repositories.CustomerRepo;
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
    @Autowired
    private CustomerRepo customerRepo;

    @PostMapping("/booking/{id}")
    public ResponseEntity<Booking> addBookHandler(@PathVariable Long id,@RequestBody Booking book) {
        return new ResponseEntity<>(bookingService.addBook(id,book), HttpStatus.CREATED);
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<String> deleteBookHandler(@PathVariable Long id) {
        return new ResponseEntity<>(bookingService.deleteBook(id), HttpStatus.OK);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Booking> getBookHandler(@PathVariable Long id){
        return new ResponseEntity<>(bookingService.getBook(id), HttpStatus.OK);
    }

    @PutMapping("/book/{id}")
    public ResponseEntity<Booking> updateReviewHandler(@PathVariable("id") Long id , @RequestBody Boolean status) {
        return new ResponseEntity<>(bookingService.updateBook(id,status), HttpStatus.OK);
    }

    @GetMapping("/booking/{tripId}")
    public ResponseEntity<List<Booking>> getAllBooksOfTripHandler(@PathVariable Long tripId){
        return new ResponseEntity<>(bookingService.getAllBooksOfTrip(tripId), HttpStatus.OK);
    }

    @GetMapping("/booking/{customerId}")
    public ResponseEntity<List<Booking>> getAllBooksOfCustomerHandler(@PathVariable Long customerId){
        return new ResponseEntity<>(bookingService.getAllBooksOfCustomer(customerId), HttpStatus.OK);
    }
    @PutMapping("/{customerId}/mark-status-read")
    public ResponseEntity<Void> markMessagesAsReadForCustomer(@PathVariable Long customerId) {
        bookingService.markStatusAsRead(customerId);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/{customerId}/unread-status-count")
    public ResponseEntity<Integer> getUnreadStatusCount(@PathVariable Long customerId) {
        Customer customer = customerRepo.findById(customerId).orElseThrow(() -> new RuntimeException("Customer not found"));;
        return ResponseEntity.ok(customer.getUnreadMessagesCount());
    }
}
