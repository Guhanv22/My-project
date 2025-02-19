package com.example.audible.Service;
import com.example.audible.model.Review;

import com.example.audible.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getAllReview() {
        return reviewRepository.findAll();
    }

    public Optional<Review> getReviewById(int id) {
        return reviewRepository.findById(id);
    }

    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    public Review saveReviewDetails(Review review) {

        return reviewRepository.save(review);
    }
}