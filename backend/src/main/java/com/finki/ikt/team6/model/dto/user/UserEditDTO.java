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
    private String username;
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

    public static UserEditDTO of(User user){
        UserEditDTO userDetails = new UserEditDTO();
        userDetails.role = user.getRole();
        userDetails.username = user.getUsername();
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
}
