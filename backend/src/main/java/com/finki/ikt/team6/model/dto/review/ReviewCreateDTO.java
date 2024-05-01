package com.finki.ikt.team6.model.dto.review;

import com.finki.ikt.team6.model.User;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ReviewCreateDTO {
    private int rating;
    private String commentar;
    private User user;
    private LocalDate date;
    private  User postUser;
    //TODO: Create date automatically when posting a review

    public static ReviewCreateDTO of(int rating, String commentar, User user, LocalDate date, User postUser){
        ReviewCreateDTO reviewCreateDTO=new ReviewCreateDTO();
        reviewCreateDTO.commentar=commentar;
        reviewCreateDTO.rating=rating;
        reviewCreateDTO.date=date;
        reviewCreateDTO.user=user;
        reviewCreateDTO.postUser=postUser;
        return  reviewCreateDTO;
    }
}
