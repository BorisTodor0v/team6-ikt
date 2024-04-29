package com.finki.ikt.team6.model.review;

import com.finki.ikt.team6.model.Review;
import com.finki.ikt.team6.model.User;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ReviewDetailsDTO {
    private Long id;
    private int rating;
    private String commentar;
    private User user;
    private LocalDate date;
    private  User postUser;

    public static ReviewDetailsDTO of(Review review){
        ReviewDetailsDTO reviewDetailsDTO=new ReviewDetailsDTO();
        reviewDetailsDTO.setId(review.getId());
        reviewDetailsDTO.setRating(review.getRating());
        reviewDetailsDTO.setCommentar(review.getCommentar());
        reviewDetailsDTO.setUser(review.getUser());
        reviewDetailsDTO.setDate(review.getDate());
        reviewDetailsDTO.setPostUser(review.getPostUser());
        return reviewDetailsDTO;
    }
}
