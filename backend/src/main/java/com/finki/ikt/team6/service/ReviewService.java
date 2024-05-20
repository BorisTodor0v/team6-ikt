package com.finki.ikt.team6.service;

import com.finki.ikt.team6.model.Review;
import com.finki.ikt.team6.model.User;

import java.time.LocalDate;
import java.util.List;

public interface ReviewService {
    List<Review> listAllReviews();
    Review findById(Long id);
    Review deleteReview(Long id);
    Review createReview(int rating, String commentar, User user, LocalDate date, User postUser);
    Review updateReview(Long id, int rating, String commentar, User user, LocalDate date, User postUser);
}
