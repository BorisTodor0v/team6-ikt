package com.finki.ikt.team6.service;

import com.finki.ikt.team6.model.Role;
import com.finki.ikt.team6.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends UserDetailsService {
    User register(String username, String password, String repeatPassword, Role role);
}
