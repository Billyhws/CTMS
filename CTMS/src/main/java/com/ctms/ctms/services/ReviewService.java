package com.ctms.ctms.services;

import com.ctms.ctms.exception.TripNotFoundException;
import com.ctms.ctms.models.Review;
import com.ctms.ctms.repositories.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReviewService {

    @Autowired
    private ReviewRepo reviewRepo;


    public Review addReview(Review review) {
        return reviewRepo.save(review);
    }

    public Review updateReview(Long id, Review review) {
        Review review1 = reviewRepo.findById(id)
                .orElseThrow(() -> new TripNotFoundException("Trip with ID " + id + " not found"));

        review1.setReviewDate(review.getReviewDate());
        review1.setComment(review.getComment());
        review1.setRating(review.getRating());
        review1.setTrip_id(review.getTrip_id());

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

    public List<Review> getAllReviewOfCustomer(Long id) {
        List<Review> reviews = reviewRepo.findAllByCustomer_id(id);
        if (reviews.isEmpty()) {
            throw new TripNotFoundException("No trips found for agency ID: " + id);
        }
        return reviews;
    }
}
