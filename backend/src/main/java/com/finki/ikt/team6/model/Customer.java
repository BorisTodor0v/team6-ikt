package com.finki.ikt.team6.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Customer {

    @Id
    private Long id;
    @OneToOne
    private  User user;
    private String name;

    private  String surname;

    private String emaiil;

    private String address;

    private int grade;

    public Customer(User user, String name, String surname, String emaiil, String address, int grade) {
        this.user = user;
        this.name = name;
        this.surname = surname;
        this.emaiil = emaiil;
        this.address = address;
        this.grade = grade;
    }

    public Customer() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmaiil() {
        return emaiil;
    }

    public void setEmaiil(String emaiil) {
        this.emaiil = emaiil;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
