package com.finki.ikt.team6.model.dto.review;

import com.finki.ikt.team6.model.User;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ReviewEditDTO {
    private int rating;
    private String commentar;
    private User user;
    private LocalDate date;
    private  User postUser;
    //TODO: Only allow changing of comment and rating, remove others

    public static  ReviewEditDTO of(int rating, String commentar, User user, LocalDate date, User postUser){
        ReviewEditDTO reviewEditDTO=new ReviewEditDTO();
        reviewEditDTO.date=date;
        reviewEditDTO.postUser=postUser;
        reviewEditDTO.commentar=commentar;
        reviewEditDTO.rating=rating;
        reviewEditDTO.user=user;
        return  reviewEditDTO;
    }
}
