package com.ctms.ctms.controllers;

import com.ctms.ctms.models.Review;
import com.ctms.ctms.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/reviews/{id}")
    public ResponseEntity<Review> addReviewHandler(@PathVariable("id") Long id ,@RequestBody Review review) {
        return new ResponseEntity<>(reviewService.addReview(id,review), HttpStatus.CREATED);
    }

    @PutMapping("/review/{id}")
    public ResponseEntity<Review> updateReviewHandler(@PathVariable("id") Long id ,@RequestBody Review review) {
        return new ResponseEntity<>(reviewService.updateReview(id,review), HttpStatus.OK);
    }

    @DeleteMapping("/review/{id}")
    public ResponseEntity<String> deleteReviewHandler(@PathVariable("id") Long id){
        return new ResponseEntity<>(reviewService.deleteReview(id), HttpStatus.OK);
    }

    @PutMapping("/{reviewId}/respond")
    public ResponseEntity<Review> respondToReview(@PathVariable Long reviewId,
                                                  @RequestBody String response) {
        Review updatedReview = reviewService.respondToReview(reviewId, response);
        return ResponseEntity.ok(updatedReview);
    }

    @GetMapping("/trip/reviews/{tripId}")
    public ResponseEntity<List<Review>> getAllReviewOfTripHandler(@PathVariable Long tripId){
        return new ResponseEntity<>(reviewService.getAllReviewOfTrip(tripId), HttpStatus.OK);
    }

    @GetMapping("/customer/reviews/{customerId}")
    public ResponseEntity<List<Review>> getAllReviewOfCustomerHandler(@PathVariable Long customerId){
        return new ResponseEntity<>(reviewService.getAllReviewOfCustomer(customerId), HttpStatus.OK);
    }
}
