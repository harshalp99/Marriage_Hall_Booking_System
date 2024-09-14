package com.harshal.reviewservice.service;

import com.harshal.reviewservice.dto.HallDTO;
import com.harshal.reviewservice.feign.HallFeignClient;
import com.harshal.reviewservice.model.Review;
import com.harshal.reviewservice.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private HallFeignClient hallFeignClient;

    // Create a new review
    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    // Get all reviews
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    // Get review by ID
    public Optional<Review> getReviewById(Long reviewId) {
        return reviewRepository.findById(reviewId);
    }

    // Update a review
    public Review updateReview(Long reviewId, Review reviewDetails) {
        Review review = reviewRepository.findById(reviewId).orElseThrow(() -> new RuntimeException("Review not found"));
        review.setComment(reviewDetails.getComment());
        review.setRating(reviewDetails.getRating());
        return reviewRepository.save(review);
    }

    // Delete a review
    public void deleteReview(Long reviewId) {
        reviewRepository.deleteById(reviewId);
    }

    // Get hall details for a review using HallFeignClient
    public HallDTO getHallForReview(Long hallId) {
        return hallFeignClient.getHallById(hallId);
    }
}
