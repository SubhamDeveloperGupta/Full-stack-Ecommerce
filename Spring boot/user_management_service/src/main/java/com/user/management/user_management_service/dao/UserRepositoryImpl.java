package com.user.management.user_management_service.dao;

import com.user.management.user_management_service.entity.UserDetails;
import com.user.management.user_management_service.repository.UserDetailsRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final UserDetailsRepository userDetailsRepository;

    public UserRepositoryImpl(UserDetailsRepository userDetailsRepository) {
        this.userDetailsRepository = userDetailsRepository;
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

    @Override
    public boolean checkUsernameAlreadyIsPresent(String username) {
        return false;
    }

    @Override
    public boolean checkEmailAlreadyIsPresent(String email) {
        return false;
    }

    @Override
    public boolean checkMobileNumberAlreadyIsPresent(String mobileNumber) {
        return false;
    }
}
