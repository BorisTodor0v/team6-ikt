package com.finki.ikt.team6.config;

import com.finki.ikt.team6.model.Role;
import com.finki.ikt.team6.model.dto.user.UserRegisterDTO;
import com.finki.ikt.team6.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final UserService userService;

    public DataInitializer(UserService userService) {
        this.userService = userService;
    }

    /**
        Create dummy users for testing purposes
     */
    @PostConstruct
    public void init(){
        UserRegisterDTO adminDTO = new UserRegisterDTO();
        adminDTO.setUsername("admin");
        adminDTO.setPassword("admin");
        adminDTO.setRepeatPassword("admin");
        adminDTO.setName("Admin");
        adminDTO.setSurname("Admin");
        adminDTO.setEmail("admin@kindly.com");
        adminDTO.setAddress("home");
        userService.register(adminDTO, Role.ADMIN);
        UserRegisterDTO userDTO = new UserRegisterDTO();
        userDTO.setUsername("user");
        userDTO.setPassword("user");
        userDTO.setRepeatPassword("user");
        userDTO.setName("Test");
        userDTO.setSurname("User");
        userDTO.setEmail("testuser@email.com");
        userDTO.setAddress("");
        userService.register(userDTO, Role.USER);
    }

}
