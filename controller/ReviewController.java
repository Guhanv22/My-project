package com.example.audible.controller;
import com.example.audible.Service.ReviewService;

import com.example.audible.model.Review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/review")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @GetMapping
    public List<Review> getAllReviews()
    {
        return reviewService.getAllReview();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable int id) {
        return reviewService.getReviewById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping("/addReviewDetails")
    public Review postReviewDetails(@RequestBody Review review) {
        return reviewService.saveReviewDetails(review);
    }
}
