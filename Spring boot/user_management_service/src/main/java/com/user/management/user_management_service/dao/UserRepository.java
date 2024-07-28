package com.user.management.user_management_service.dao;


import com.user.management.user_management_service.entity.UserDetails;

import java.util.List;

public interface UserRepository {

    List<UserDetails> getAllUserDetails();
    UserDetails getUserDetailsById(Integer userId);
    UserDetails CreateUserDetails(UserDetails userDetails);
    UserDetails UpdateUserDetails(Integer userId, UserDetails userDetails);

    boolean checkUsernameAlreadyIsPresent(String username);
    boolean checkEmailAlreadyIsPresent(String email);
    boolean checkMobileNumberAlreadyIsPresent(String mobileNumber);
    
}
