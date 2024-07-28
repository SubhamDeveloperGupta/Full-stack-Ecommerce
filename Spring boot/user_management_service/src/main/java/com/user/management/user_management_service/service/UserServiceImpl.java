package com.user.management.user_management_service.service;

import com.user.management.user_management_service.dao.UserRepository;
import com.user.management.user_management_service.entity.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDetails> getAllUserDetails() {
        return List.of();
    }

    @Override
    public UserDetails getUserDetailsById(Integer userId) {
        return null;
    }

    @Override
    public UserDetails CreateUserDetails(UserDetails userDetails) {
        return null;
    }

    @Override
    public UserDetails UpdateUserDetails(Integer userId, UserDetails userDetails) {
        return null;
    }
}
