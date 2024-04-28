package com.finki.ikt.team6.controller.web;

import com.finki.ikt.team6.model.Review;
import com.finki.ikt.team6.model.exceptions.ReviewNotFoundException;
import com.finki.ikt.team6.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/review")
public class ReviewController {
    private ReviewService reviewService;

    @GetMapping
    public String getAllReviews(Model model) {
        List<Review> reviews = reviewService.listAllReviews();
        model.addAttribute("reviews", reviews);
        return "review-list";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long id) {
        try {
            Review review = reviewService.findById(id);
            return new ResponseEntity<>(review, HttpStatus.OK);
        } catch (ReviewNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Void> createReview(@RequestBody Review review) {
        Review createdReview = reviewService.createReview(review.getRating(), review.getCommentar(), review.getUserId(), review.getDate());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("edit/{id}")
    public ResponseEntity<Void> updateReview(@PathVariable Long id, @RequestBody Review review) {
        review.setId(id);
        reviewService.updateReview(review.getId(), review.getRating(), review.getCommentar(), review.getUserId(), review.getDate());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
