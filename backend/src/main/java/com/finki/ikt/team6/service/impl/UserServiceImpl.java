package com.finki.ikt.team6.service.impl;

import com.finki.ikt.team6.model.Role;
import com.finki.ikt.team6.model.User;
import com.finki.ikt.team6.model.dto.user.UserEditDTO;
import com.finki.ikt.team6.model.exceptions.InvalidUsernameOrPasswordException;
import com.finki.ikt.team6.model.exceptions.PasswordsDoNotMatchException;
import com.finki.ikt.team6.model.exceptions.UsernameAlreadyExistsException;
import com.finki.ikt.team6.model.exceptions.UsernameDoesNotExistException;
import com.finki.ikt.team6.repository.UserRepository;
import com.finki.ikt.team6.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
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
    public User register(String username, String password, String repeatPassword, Role role) {
        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            throw new InvalidUsernameOrPasswordException();
        }

        if (!password.equals(repeatPassword)) {
            throw new PasswordsDoNotMatchException();
        }

        if(this.userRepository.findByUsername(username).isPresent()) {
            throw new UsernameAlreadyExistsException(username);
        }

        User user = new User(username, passwordEncoder.encode(password), role);

        return userRepository.save(user);
    }

    @Override
    public List<User> listAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(()->new UsernameDoesNotExistException(username));
    }

    @Override
    @Transactional
    public User edit(String username, UserEditDTO userEditDTO) {
        User user = userRepository.findByUsername(username).orElseThrow(()->new UsernameDoesNotExistException(username));
        user.setRole(userEditDTO.getRole());
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
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException(username));
    }
}