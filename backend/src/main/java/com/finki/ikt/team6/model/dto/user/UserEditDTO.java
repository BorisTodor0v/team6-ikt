package com.finki.ikt.team6.model.dto.user;

import com.finki.ikt.team6.model.Role;
import com.finki.ikt.team6.model.User;
import lombok.Data;

/**
 * Used as ResponseBody when editing user details. Currently, only contains the role of the user. Expand when adding other data to the user model.
 */
@Data
public class UserEditDTO {
    private Role role;

    public static UserEditDTO of(User user){
        UserEditDTO userDetails = new UserEditDTO();
        userDetails.role = user.getRole();
        return userDetails;
    }
}
