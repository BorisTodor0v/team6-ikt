package com.finki.ikt.team6.config;

import com.finki.ikt.team6.model.Role;
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
        userService.register("admin", "admin", "admin", Role.ADMIN);
        userService.register("user", "user", "user", Role.USER);
    }

}
