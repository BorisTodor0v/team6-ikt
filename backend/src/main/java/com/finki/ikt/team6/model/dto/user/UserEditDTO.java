package com.finki.ikt.team6.model.dto.user;

import com.finki.ikt.team6.model.Role;
import com.finki.ikt.team6.model.User;
import lombok.Data;

/**
 * Used as ResponseBody when editing user details. Contains all data related to the user.
 */
@Data
public class UserEditDTO {
    private Role role;
    private String name;
    private String surname;
    private String email;
    private String address;

    public static UserEditDTO of(User user){
        UserEditDTO userDetails = new UserEditDTO();
        userDetails.role = user.getRole();
        userDetails.name = user.getName();
        userDetails.surname = user.getSurname();
        userDetails.email = user.getSurname();
        userDetails.address = user.getAddress();
        return userDetails;
    }
}
