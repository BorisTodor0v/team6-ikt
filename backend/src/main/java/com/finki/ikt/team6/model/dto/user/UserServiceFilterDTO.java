package com.finki.ikt.team6.model.dto.user;

import lombok.Data;

@Data
public class UserServiceFilterDTO {
    private double minSalary;
    private double maxSalary;
    private boolean trainedInFirstAid;
    private boolean comfortableWithPets;
    private boolean highEducation;
    private boolean hasCar;
    private boolean nonSmoker;
    private boolean requiresChildCare;
    private boolean requiresElderCare;
    private boolean requiresPetCare;
}
