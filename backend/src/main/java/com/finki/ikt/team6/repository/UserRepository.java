package com.finki.ikt.team6.repository;

import com.finki.ikt.team6.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByUsernameAndPassword(String username, String password);
    Optional<User> findByEmailAndPassword(String email, String password);
    List<User> findByMinSalaryGreaterThanEqualAndMaxSalaryLessThanEqualAndTrainedInFirstAidAndComfortableWithPetsAndHighEducationAndHasCarAndNonSmokerAndOffersChildCareAndOffersElderCareAndOffersPetCare(
            Double minSalary, Double maxSalary,
            Boolean trainedInFirstAid, Boolean comfortableWithPets, Boolean highEducation,
            Boolean hasCar, Boolean nonSmoker,
            Boolean offersChildCare, Boolean offersElderCare, Boolean offersPetCare);
}
