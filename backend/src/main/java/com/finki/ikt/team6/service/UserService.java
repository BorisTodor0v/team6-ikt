package com.finki.ikt.team6.service;

import com.finki.ikt.team6.model.Role;
import com.finki.ikt.team6.model.User;
import com.finki.ikt.team6.model.dto.user.UserDetailsDTO;
import com.finki.ikt.team6.model.dto.user.UserEditDTO;
import com.finki.ikt.team6.model.dto.user.UserRegisterDTO;
//import org.springframework.security.core.userdetails.UserDetailsService;
import com.finki.ikt.team6.model.dto.user.UserServiceFilterDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService { //extends UserDetailsService {
    User register(UserRegisterDTO userRegisterDTO, Role role);
    List<User> listAll();
    UserDetailsDTO findByUsername(String username);
    UserDetailsDTO findById(Long id);
    User getUserByUsername(String username);
    User getUserById(Long id);
    User edit(String username, UserEditDTO userEditDTO);
    User edit(Long id, UserEditDTO userEditDTO);
    User delete(String username);
    User delete(Long id);
    User findByCredentials(String email, String password);
    List<UserDetailsDTO> findServiceProviders(UserServiceFilterDTO filterDTO);
    List<UserDetailsDTO> findChildCare();
    List<UserDetailsDTO> findElderCare();
    List<UserDetailsDTO> findPetCare();
}
