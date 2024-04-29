package com.finki.ikt.team6.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ValueGenerationType;

import java.time.LocalDate;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int rating;
    private String commentar;
    @ManyToOne
    private User user;
    private LocalDate date;
    @ManyToOne
    private  User postUser;

    public Review(int rating, String commentar, User user, LocalDate date, User postUser) {
        this.rating = rating;
        this.commentar = commentar;
        this.user=user;
        this.postUser=postUser;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public User getPostUser() {
        return postUser;
    }

    public void setPostUser(User postUser) {
        this.postUser = postUser;
    }
}
