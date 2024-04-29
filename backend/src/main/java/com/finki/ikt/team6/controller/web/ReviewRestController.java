package com.finki.ikt.team6.controller.web;

import com.finki.ikt.team6.model.Review;
import com.finki.ikt.team6.model.exceptions.ReviewNotFoundException;
import com.finki.ikt.team6.model.review.ReviewCreateDTO;
import com.finki.ikt.team6.model.review.ReviewDetailsDTO;
import com.finki.ikt.team6.model.review.ReviewEditDTO;
import com.finki.ikt.team6.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
@RequestMapping("/api/review")
public class ReviewRestController {
    private ReviewService reviewService;

    @GetMapping
    public List<Review> listAllReview(){
        return this.reviewService.listAllReviews();
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getReviewById(@PathVariable Long id) {
        try {
            Review review = reviewService.findById(id);
            return new ResponseEntity<>(review, HttpStatus.OK);
        } catch (ReviewNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> createReview(@RequestBody ReviewCreateDTO reviewCreateDTO) {
        try{
            ReviewDetailsDTO review = ReviewDetailsDTO.of(this.reviewService.createReview(reviewCreateDTO.getRating(), reviewCreateDTO.getCommentar(), reviewCreateDTO.getUser(), reviewCreateDTO.getDate(), reviewCreateDTO.getPostUser()));
            return new ResponseEntity<>(review, HttpStatus.CREATED);
        } catch (ReviewNotFoundException e) {
            return ResponseEntity.status(e.getStatus()).body(e.getMessage());
        }
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<?> updateReview(@PathVariable Long id, @RequestBody ReviewEditDTO reviewEditDTO) {
        try{
            ReviewDetailsDTO review = ReviewDetailsDTO.of(this.reviewService.updateReview(id, reviewEditDTO.getRating(), reviewEditDTO.getCommentar(),reviewEditDTO.getUser(), reviewEditDTO.getDate(), reviewEditDTO.getPostUser()));
            return new ResponseEntity<>(review, HttpStatus.OK);
        } catch (ReviewNotFoundException e){
            return ResponseEntity.status(e.getStatus()).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> deleteReview(@PathVariable Long id) {
        try{
            ReviewDetailsDTO review=ReviewDetailsDTO.of(this.reviewService.deleteReview(id));
            return new ResponseEntity<>(review, HttpStatus.OK);
        }catch (ReviewNotFoundException e){
            return ResponseEntity.status(e.getStatus()).body(e.getMessage());
        }

    }

}
