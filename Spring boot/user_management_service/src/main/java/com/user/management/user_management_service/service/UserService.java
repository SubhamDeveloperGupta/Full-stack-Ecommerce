package com.user.management.user_management_service.service;


import com.user.management.user_management_service.entity.UserDetails;

import java.util.List;

public interface UserService {

    List<UserDetails> getAllUserDetails();
    UserDetails getUserDetailsById(Integer userId);
    UserDetails createUserDetails(UserDetails userDetails);
    UserDetails updateUserDetails(Integer userId, UserDetails userDetails);



}
