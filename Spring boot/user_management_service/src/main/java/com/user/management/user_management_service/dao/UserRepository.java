package com.user.management.user_management_service.dao;


import com.user.management.user_management_service.entity.UserDetails;

import java.util.List;

public interface UserRepository {

    List<UserDetails> getAllUsers();
    UserDetails getUserByUserId(Integer userId);
    UserDetails createUser(UserDetails userDetails);

}
