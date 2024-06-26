package com.finki.ikt.team6.service.impl;

import com.finki.ikt.team6.model.Role;
import com.finki.ikt.team6.model.User;
import com.finki.ikt.team6.model.dto.user.UserDetailsDTO;
import com.finki.ikt.team6.model.dto.user.UserEditDTO;
import com.finki.ikt.team6.model.dto.user.UserRegisterDTO;
import com.finki.ikt.team6.model.dto.user.UserServiceFilterDTO;
import com.finki.ikt.team6.model.exceptions.*;
import com.finki.ikt.team6.repository.UserRepository;
import com.finki.ikt.team6.service.UserService;
import jakarta.transaction.Transactional;
/*
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
 */
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    //private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository){ //, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        //this.passwordEncoder = passwordEncoder;
    }

    /*  TODO: Remove the "Role" parameter from the function
            Reason being - when a new user is created the role they are automatically assigned is a regular user
            The admins are the ones who can change the role of a user.
            The only reason the role is as an input parameter is to add users with various roles in the DataInitializer component
            After properly implementing users, permissions and a database, remove the input parameter from the function.
                Also, in the future when using a database, make sure you can't delete all admin users, that there must be at least one.
                Otherwise key functionality in the app breaks.
    */
    @Override
    public User register(UserRegisterDTO userRegisterDTO, Role role) {

        if (userRegisterDTO.getUsername() == null || userRegisterDTO.getPassword() == null
                || userRegisterDTO.getUsername().isEmpty() || userRegisterDTO.getPassword().isEmpty()) {
            throw new InvalidUsernameOrPasswordException();
        }

        if (!userRegisterDTO.getPassword().equals(userRegisterDTO.getRepeatPassword())) {
            throw new PasswordsDoNotMatchException();
        }

        if(this.userRepository.findByUsername(userRegisterDTO.getUsername()).isPresent()) {
            throw new UsernameAlreadyExistsException(userRegisterDTO.getUsername());
        }

        //User user = new User(userRegisterDTO.getUsername(), passwordEncoder.encode(userRegisterDTO.getPassword()), role);
        User user = new User(userRegisterDTO.getUsername(), userRegisterDTO.getPassword(), role);

        user.setName(userRegisterDTO.getName());
        user.setSurname(userRegisterDTO.getSurname());
        user.setEmail(userRegisterDTO.getEmail());
        user.setAddress(userRegisterDTO.getAddress());

        return userRepository.save(user);
    }

    @Override
    public List<User> listAll() {
        return userRepository.findAll();
    }

    @Override
    public UserDetailsDTO findByUsername(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(()->new UsernameDoesNotExistException(username));
        return UserDetailsDTO.of(user);
    }

    @Override
    public UserDetailsDTO findById(Long id) {
        User user = userRepository.findById(id).orElseThrow(()->new UserIdDoesNotExistException(id));
        return UserDetailsDTO.of(user);
    }

    @Override
    public User getUserByUsername(String username){
        return userRepository.findByUsername(username).orElseThrow(()->new UsernameDoesNotExistException(username));
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(()->new UserIdDoesNotExistException(id));
    }

    @Override
    @Transactional
    public User edit(String username, UserEditDTO userEditDTO) {
        User user = userRepository.findByUsername(username).orElseThrow(()->new UsernameDoesNotExistException(username));
        user.setRole(userEditDTO.getRole());
        user.setUsername(userEditDTO.getUsername());
        user.setName(userEditDTO.getName());
        user.setSurname(userEditDTO.getSurname());
        user.setEmail(userEditDTO.getEmail());
        user.setAddress(userEditDTO.getAddress());
        return user;
    }

    @Override
    @Transactional
    public User edit(Long id, UserEditDTO userEditDTO) {
        User user = userRepository.findById(id).orElseThrow(()->new UserIdDoesNotExistException(id));
        user.setRole(userEditDTO.getRole());
        user.setUsername(userEditDTO.getUsername());
        user.setName(userEditDTO.getName());
        user.setSurname(userEditDTO.getSurname());
        user.setEmail(userEditDTO.getEmail());
        user.setAddress(userEditDTO.getAddress());
        user.setGrade(userEditDTO.getGrade());
        // Services offered
        user.setOffersChildCare(userEditDTO.isOffersChildCare());
        user.setOffersElderCare(userEditDTO.isOffersElderCare());
        user.setOffersPetCare(userEditDTO.isOffersPetCare());
        // Salary Range
        user.setMinSalary(userEditDTO.getMinSalary());
        user.setMaxSalary(userEditDTO.getMaxSalary());
        // Traits
        user.setTrainedInFirstAid(userEditDTO.isTrainedInFirstAid());
        user.setComfortableWithPets(userEditDTO.isComfortableWithPets());
        user.setHighEducation(userEditDTO.isHighEducation());
        user.setHasCar(userEditDTO.isHasCar());
        user.setNonSmoker(userEditDTO.isNonSmoker());
        return user;
    }

    @Override
    @Transactional
    public User delete(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(()->new UsernameDoesNotExistException(username));
        userRepository.delete(user);
        return user;
    }

    @Override
    public User delete(Long id) {
        User user = userRepository.findById(id).orElseThrow(()->new UserIdDoesNotExistException(id));
        userRepository.delete(user);
        return user;
    }

    @Override
    public User findByCredentials(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password).orElseThrow(InvalidEmailOrPasswordException::new);
    }
/*
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException(username));
    }

 */
    @Override
    public List<UserDetailsDTO> findServiceProviders(UserServiceFilterDTO filterDTO) {
        List<UserDetailsDTO> serviceProviders = userRepository.findByMinSalaryGreaterThanEqualAndMaxSalaryLessThanEqualAndTrainedInFirstAidAndComfortableWithPetsAndHighEducationAndHasCarAndNonSmokerAndOffersChildCareAndOffersElderCareAndOffersPetCare(
                        filterDTO.getMinSalary(), filterDTO.getMaxSalary(),
                        filterDTO.isTrainedInFirstAid(), filterDTO.isComfortableWithPets(), filterDTO.isHighEducation(),
                        filterDTO.isHasCar(), filterDTO.isNonSmoker(),
                        filterDTO.isRequiresChildCare(), filterDTO.isRequiresElderCare(), filterDTO.isRequiresPetCare())
                .stream()
                .map(UserDetailsDTO::of)
                .collect(Collectors.toList());
        return serviceProviders;
    }

    @Override
    public List<UserDetailsDTO> findChildCare() {
        return userRepository.findUsersByOffersChildCare(true)
                .stream()
                .map(UserDetailsDTO::of)
                .toList();
    }

    @Override
    public List<UserDetailsDTO> findElderCare() {
        return userRepository.findUsersByOffersElderCare(true)
                .stream()
                .map(UserDetailsDTO::of)
                .toList();
    }

    @Override
    public List<UserDetailsDTO> findPetCare() {
        return userRepository.findUsersByOffersPetCare(true)
                .stream()
                .map(UserDetailsDTO::of)
                .toList();
    }

}
