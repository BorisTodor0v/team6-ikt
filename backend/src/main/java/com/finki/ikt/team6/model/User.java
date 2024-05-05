package com.finki.ikt.team6.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
/*
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
 */

@Data
@NoArgsConstructor
@Entity
@Table(name = "app_users")
public class User { //implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    @Enumerated(value = EnumType.STRING)
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

    /*
    private boolean isAccountNonExpired = true;
    private boolean isAccountNonLocked = true;
    private boolean isCredentialsNonExpired =  true;
    private boolean isEnabled = true;

     */

    public User(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
/*
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(role);
    }

 */
}
