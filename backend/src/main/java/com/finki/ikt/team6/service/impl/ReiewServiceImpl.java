package com.finki.ikt.team6.service.impl;

import com.finki.ikt.team6.model.Customer;
import com.finki.ikt.team6.model.Review;
import com.finki.ikt.team6.model.User;
import com.finki.ikt.team6.model.exceptions.ReviewNotFoundException;
import com.finki.ikt.team6.repository.ReviewRepository;
import com.finki.ikt.team6.service.ReviewService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReiewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    public ReiewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> listAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Review findById(Long id) {
        return reviewRepository.findById(id).orElseThrow(ReviewNotFoundException::new);
    }

    @Override
    public Review deleteReview(Long id) {
        Review review = findById(id);
        reviewRepository.deleteById(id);
        return review;
    }

    @Override
    public Review createReview(int rating, String commentar, User user, LocalDate date, User postUser) {
        Review review=new Review(rating, commentar, user, date, postUser);
        return  reviewRepository.save(review);
    }

    @Override
    public Review updateReview(Long id, int rating, String commentar, User user, LocalDate date, User postUser) {
        Review review = findById(id);

        review.setRating(rating);
        review.setCommentar(commentar);
        review.setUser(user);
        review.setDate(date);
        review.setPostUser(postUser);

        return reviewRepository.save(review);
    }
}
