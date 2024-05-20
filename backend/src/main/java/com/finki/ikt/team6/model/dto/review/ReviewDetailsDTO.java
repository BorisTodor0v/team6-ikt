package com.finki.ikt.team6.model.dto.review;

import com.finki.ikt.team6.model.Review;
import com.finki.ikt.team6.model.User;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    public static List<ReviewDetailsDTO> of(List<Review> reviews){
        List<ReviewDetailsDTO> reviewDetailsDTOS = new ArrayList<>();
        for (Review review : reviews) {
            reviewDetailsDTOS.add(ReviewDetailsDTO.of(review));
        }
        return reviewDetailsDTOS;
    }
}
