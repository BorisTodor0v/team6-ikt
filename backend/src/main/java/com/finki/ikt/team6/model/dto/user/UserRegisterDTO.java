package com.finki.ikt.team6.model.dto.user;

import lombok.Data;

/**
 * Used as ResponseBody when registering a new user. Contains username, password and password confirmation. Expand when adding other data to the user model.
 */
@Data
public class UserRegisterDTO {
    private String username;
    private String password;
    private String repeatPassword;
    private String name;
    private String surname;
    private String email;
    private String address;

    public static UserRegisterDTO of(String username, String password, String repeatPassword, String name, String surname, String email, String address){
        UserRegisterDTO userDetails = new UserRegisterDTO();
        userDetails.username = username;
        userDetails.password = password;
        userDetails.repeatPassword = repeatPassword;
        userDetails.name = name;
        userDetails.surname = surname;
        userDetails.email = email;
        userDetails.address = address;
        return userDetails;
    }
}