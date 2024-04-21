package com.finki.ikt.team6.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Review {
    @Id
    private Long id;
    private int rating;
    private String commentar;
    private Long userId;
    private LocalDate date;

    public Review(int rating, String commentar, Long userId, LocalDate date) {
        this.rating = rating;
        this.commentar = commentar;
        this.userId = userId;
    }

    public Review() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getCommentar() {
        return commentar;
    }

    public void setCommentar(String commentar) {
        this.commentar = commentar;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
