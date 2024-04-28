package com.finki.ikt.team6.service;

import com.finki.ikt.team6.model.Review;

import java.time.LocalDate;
import java.util.List;

public interface ReviewService {
    List<Review> listAllReviews();
    Review findById(Long id);
    Review deleteReview(Long id);
    Review createReview(int rating, String commentar, Long userId, LocalDate date);
    Review updateReview(Long id, int rating, String commentar, Long userId, LocalDate date);
}
