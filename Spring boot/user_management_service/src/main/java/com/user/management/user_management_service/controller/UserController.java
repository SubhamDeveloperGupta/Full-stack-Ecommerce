package com.user.management.user_management_service.controller;

import com.user.management.user_management_service.entity.UserDetails;
import com.user.management.user_management_service.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDetails>> getAllUser() {
        return new ResponseEntity<>(userService.getAllUserDetails(), HttpStatus.OK);
    }

    @GetMapping(params = "userId")
    public ResponseEntity<UserDetails> getUserById(@RequestParam Integer userId) {
        return new ResponseEntity<>(userService.getUserDetailsById(userId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDetails> createUserDetails(@RequestBody UserDetails userDetails) {
        return new ResponseEntity<>(userService.createUserDetails(userDetails), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<UserDetails> updateUserDetails(@RequestParam Integer userId, @RequestBody UserDetails userDetails) {
        return new ResponseEntity<>(userService.updateUserDetails(userId, userDetails), HttpStatus.OK);
    }

}
