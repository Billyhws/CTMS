package com.ctms.ctms.services;

import com.ctms.ctms.exception.TripNotFoundException;
import com.ctms.ctms.models.Review;
import com.ctms.ctms.models.Trip;
import com.ctms.ctms.repositories.ReviewRepo;
import com.ctms.ctms.repositories.TripRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class ReviewService {

    @Autowired
    private ReviewRepo reviewRepo;
    @Autowired
    private TripRepo tripRepo;


    public Review addReview(Long id,Review review) {
        Trip trip = tripRepo.findById(id)
                .orElseThrow(() -> new TripNotFoundException("Trip with ID " + id + " not found"));
        review.setTrip(trip);
        return reviewRepo.save(review);

    }

    public Review updateReview(Long id, Review review) {
        Review review1 = reviewRepo.findById(id)
                .orElseThrow(() -> new TripNotFoundException("Trip with ID " + id + " not found"));

        review1.setComment(review.getComment());
        review1.setRating(review.getRating());

        return reviewRepo.save(review1);
    }

    public String deleteReview(Long id) {

        Review review = reviewRepo.findById(id)
                .orElseThrow(() -> new TripNotFoundException("Trip with ID " + id + " not found"));

        reviewRepo.delete(review);
        return "Trip with ID " + id + " deleted successfully";
    }

    public List<Review> getAllReviewOfTrip(Long id) {
        List<Review> reviews = reviewRepo.findAllByTrip_id(id);
        if (reviews.isEmpty()) {
            throw new TripNotFoundException("No trips found for agency ID: " + id);
        }
        return reviews;
    }

    public Review respondToReview(Long reviewId, String response) {
        Review review = reviewRepo.findById(reviewId)
                .orElseThrow(() -> new RuntimeException("Review not found"));

        review.setResponse(response);
        review.setResponseDate(LocalDateTime.now());

        return reviewRepo.save(review);
    }

    public List<Review> getAllReviewOfCustomer(Long id) {
        List<Review> reviews = reviewRepo.findAllByCustomer_id(id);
        if (reviews.isEmpty()) {
            throw new TripNotFoundException("No trips found for agency ID: " + id);
        }
        return reviews;
    }
}
