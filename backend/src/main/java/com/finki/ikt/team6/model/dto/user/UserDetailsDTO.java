package com.finki.ikt.team6.model.dto.user;

import com.finki.ikt.team6.model.Role;
import com.finki.ikt.team6.model.User;
import lombok.Data;

/**
 * Used as a ResponseBody that contains necessary details of a user. Defined like this to avoid sending passwords and other sensitive data when looking up a user.
 * @Returns: Username, role of the user, first name, last name, email address, residential address and grade from reviews.
 */
@Data
public class UserDetailsDTO {
    private String username;
    private Role role;
    private String name;
    private String surname;
    private String email;
    private String address;
    private double grade;

    public static UserDetailsDTO of(User user){
        UserDetailsDTO userDetails = new UserDetailsDTO();
        userDetails.username = user.getUsername();
        userDetails.role = user.getRole();
        userDetails.name = user.getName();
        userDetails.surname = user.getSurname();
        userDetails.email = user.getEmail();
        userDetails.address = user.getAddress();
        userDetails.grade = user.getGrade();
        return userDetails;
    }
}
