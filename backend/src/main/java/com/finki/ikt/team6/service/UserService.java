package com.finki.ikt.team6.service;

import com.finki.ikt.team6.model.Role;
import com.finki.ikt.team6.model.User;
import com.finki.ikt.team6.model.dto.user.UserDetailsDTO;
import com.finki.ikt.team6.model.dto.user.UserEditDTO;
import com.finki.ikt.team6.model.dto.user.UserRegisterDTO;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService { //extends UserDetailsService {
    User register(UserRegisterDTO userRegisterDTO, Role role);
    List<User> listAll();
    UserDetailsDTO findByUsername(String username);
    User getUserByUsername(String username);
    User edit(String username, UserEditDTO userEditDTO);
    User delete(String username);
}
