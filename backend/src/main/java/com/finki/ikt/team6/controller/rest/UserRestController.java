package com.finki.ikt.team6.controller.rest;

import com.finki.ikt.team6.model.Role;
import com.finki.ikt.team6.model.User;
import com.finki.ikt.team6.model.dto.user.UserDetailsDTO;
import com.finki.ikt.team6.model.dto.user.UserEditDTO;
import com.finki.ikt.team6.model.dto.user.UserRegisterDTO;
import com.finki.ikt.team6.model.exceptions.*;
import com.finki.ikt.team6.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
@RequestMapping("/api/users")
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    /**
     * @return All users
     */
    @GetMapping
    public List<User> listAllUsers(){
        return this.userService.listAll();
    }

    /**
     * @param username
     * @return Details for the corresponding user
     */
    @GetMapping("/{username}")
    public ResponseEntity<?> findByUsername(@PathVariable String username){
        try{
            UserDetailsDTO user = this.userService.findByUsername(username);
            return new ResponseEntity<>(user, HttpStatus.FOUND);
        } catch (UsernameDoesNotExistException e){
            return ResponseEntity.status(e.getStatus()).body(e.getMessage());
        }
    }

    //TODO: Move in separate Auth Controller / Service
    /**
     * Takes user credentials from a request body and passes it to register function of the User Service to check their validity.
     * If all credentials are valid, a new user is created and an HTTP status of "CREATED" is returned.
     * If the provided username or password is invalid, or the passwords do not match, an HTTP status of "BAD_REQUEST" is returned and a new user is not created.
     * If the provided username already belongs to an existing user, an HTTP status of "CONFLICT" is returned and a new user is not created.
     * Additionally, for each condition that the form is invalid, an appropriate error message is returned to display what is the problem.
     * @param userRegisterDTO Contains all relevant user information
     * @return ResponseEntity based on validity of credentials
     */
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegisterDTO userRegisterDTO){
        try{
            User user = this.userService.register(userRegisterDTO, Role.USER);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } catch (InvalidUsernameOrPasswordException e){
            return ResponseEntity.status(e.getStatus()).body(e.getMessage());
        } catch (PasswordsDoNotMatchException e){
            return ResponseEntity.status(e.getStatus()).body(e.getMessage());
        } catch (UsernameAlreadyExistsException e){
            return ResponseEntity.status(e.getStatus()).body(e.getMessage());
        }

    }

    /*
        TODO: Make this function take the currently logged in user to see if they have permissions to edit
            Users can edit their own information except their username and their role
            Admins can only edit the roles of users
     */
    /**
     * @param username Which users info is being edited
     * @param userEditDTO The users new information after editing
     * @return Updated user information
     */
    @PutMapping("/{username}/edit")
    public ResponseEntity<?> editUserDetails(@PathVariable String username, @RequestBody UserEditDTO userEditDTO){
        try{
            User user = this.userService.edit(username, userEditDTO);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (UsernameDoesNotExistException e){
            return ResponseEntity.status(e.getStatus()).body(e.getMessage());
        }
    }

    /*
        TODO: Make this function take the currently logged in user to see if they have permissions to delete
            A user can delete their own account
            Admins are allowed to delete users
     */
    /**
     * Deletes a user
     * @param username User to delete
     * @return Information of the deleted user
     */
    @DeleteMapping("/{username}/delete")
    public ResponseEntity<?> deleteUser(@PathVariable String username){
        try{
            User user = this.userService.delete(username);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (UsernameDoesNotExistException e){
            return ResponseEntity.status(e.getStatus()).body(e.getMessage());
        }
    }

}
