package com.user.management.user_management_service.dao;

import com.user.management.user_management_service.entity.UserDetails;
import com.user.management.user_management_service.exceptions.UserNotFoundException;
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
        return userDetailsRepository.findAll();
    }

    @Override
    public UserDetails getUserDetailsById(Integer userId) {
        return userDetailsRepository.findById(userId)
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public UserDetails createUserDetails(UserDetails userDetails) {
        return userDetailsRepository.save(userDetails);
    }

    @Override
    public UserDetails updateUserDetails(UserDetails userDetails) {
        return userDetailsRepository.save(userDetails);
    }

    @Override
    public boolean checkUsernameAlreadyIsPresent(String username) {
        return userDetailsRepository.existsByUserName(username);
    }

    @Override
    public boolean checkEmailAlreadyIsPresent(String email) {
        return userDetailsRepository.existsByEmail(email.toLowerCase());
    }

    @Override
    public boolean checkMobileNumberAlreadyIsPresent(String mobileNumber) {
        return userDetailsRepository.existsByMobileNumber(mobileNumber);
    }
}
