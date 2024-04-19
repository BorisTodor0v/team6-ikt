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

    public static UserRegisterDTO of(String username, String password, String repeatPassword){
        UserRegisterDTO userDetails = new UserRegisterDTO();
        userDetails.username = username;
        userDetails.password = password;
        userDetails.repeatPassword = repeatPassword;
        return userDetails;
    }
}