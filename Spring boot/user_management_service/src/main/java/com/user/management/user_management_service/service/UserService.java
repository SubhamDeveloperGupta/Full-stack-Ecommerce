package com.user.management.user_management_service.service;


import com.user.management.user_management_service.entity.UserDetails;

import java.util.List;

public interface UserService {

    List<UserDetails> getAllUserDetails();
    UserDetails getUserDetailsById(Integer userId);
    UserDetails CreateUserDetails(UserDetails userDetails);
    UserDetails UpdateUserDetails(Integer userId, UserDetails userDetails);



}
