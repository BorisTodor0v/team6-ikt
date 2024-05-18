package com.finki.ikt.team6.model.dto.user;

import com.finki.ikt.team6.model.Role;
import com.finki.ikt.team6.model.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Used as a ResponseBody that contains necessary details of a user. Defined like this to avoid sending passwords and other sensitive data when looking up a user.
 * @Returns: Username, role of the user, first name, last name, email address, residential address and grade from reviews.
 */
@Data
public class UserDetailsDTO {
    private Long id;
    private String username;
    private Role role;
    private String name;
    private String surname;
    private String email;
    private String address;
    private double grade;
    // Services offered
    private boolean offersChildCare;
    private boolean offersElderCare;
    private boolean offersPetCare;
    // Salary Range
    private double minSalary;
    private double maxSalary;
    // Traits
    private boolean trainedInFirstAid;
    private boolean comfortableWithPets;
    private boolean highEducation;
    private boolean hasCar;
    private boolean nonSmoker;

    public static UserDetailsDTO of(User user){
        UserDetailsDTO userDetails = new UserDetailsDTO();
        userDetails.id = user.getId();
        userDetails.username = user.getUsername();
        userDetails.role = user.getRole();
        userDetails.name = user.getName();
        userDetails.surname = user.getSurname();
        userDetails.email = user.getEmail();
        userDetails.address = user.getAddress();
        userDetails.grade = user.getGrade();
        // Services offered
        userDetails.offersChildCare = user.isOffersChildCare();
        userDetails.offersElderCare = user.isOffersElderCare();
        userDetails.offersPetCare = user.isOffersPetCare();
        // Salary Range
        userDetails.minSalary = user.getMinSalary();
        userDetails.maxSalary = user.getMaxSalary();
        // Traits
        userDetails.trainedInFirstAid = user.isTrainedInFirstAid();
        userDetails.comfortableWithPets = user.isComfortableWithPets();
        userDetails.highEducation = user.isHighEducation();
        userDetails.hasCar = user.isHasCar();
        userDetails.nonSmoker = user.isNonSmoker();
        return userDetails;
    }

    public static List<UserDetailsDTO> of(List<User> users){
        List<UserDetailsDTO> userDetailsDTOS = new ArrayList<>();
        for (User user : users) {
            userDetailsDTOS.add(UserDetailsDTO.of(user));
        }
        return userDetailsDTOS;
    }
}
