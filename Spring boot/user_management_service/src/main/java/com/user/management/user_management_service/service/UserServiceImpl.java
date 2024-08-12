package com.user.management.user_management_service.service;

import com.user.management.user_management_service.dao.UserRepository;
import com.user.management.user_management_service.entity.UserDetails;
import com.user.management.user_management_service.exceptions.GlobalException;
import com.user.management.user_management_service.exceptions.UserNotFoundException;
import com.user.management.user_management_service.kafka.KafkaProducerService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final KafkaProducerService kafka;

    public UserServiceImpl(UserRepository userRepository, KafkaProducerService kafka) {
        this.userRepository = userRepository;
        this.kafka = kafka;
    }

    @Override
    public List<UserDetails> getAllUserDetails() {
        return userRepository.getAllUserDetails();
    }

    @Override
    public UserDetails getUserDetailsById(Integer userId) {
        return userRepository.getUserDetailsById(userId);
    }

    @Override
    public UserDetails createUserDetails(UserDetails userDetails) {
        filterFields(userDetails);
        UserDetails userObj = userRepository.createUserDetails(userDetails);
        kafka.sendObjectToKafkaTopic(userObj);
        return userObj;
    }

    private void filterFields(UserDetails userDetails) {
        checkUserDetails(userDetails);
        if(userRepository.checkMobileNumberAlreadyIsPresent(userDetails.getMobileNumber()))
            throw new GlobalException("Mobile Number already present");
        if(userRepository.checkEmailAlreadyIsPresent(userDetails.getEmail()))
            throw new GlobalException("Email Already present");
        if(userRepository.checkUsernameAlreadyIsPresent(userDetails.getEmail()))
            throw new GlobalException("Username Already present");
        if(userDetails.getPassword().length() >= 8)
            throw new GlobalException("Password length should 8 characters");
    }

    private void checkUserDetails(UserDetails userDetails) {
        if(userDetails.getUserId() != null)
            throw new GlobalException("User Should not be present");
        if(userDetails.getUserName() == null)
            throw new GlobalException("Username is mandatory");
        if(userDetails.getEmail() == null)
            throw new GlobalException("Email is mandatory");
        if(userDetails.getMobileNumber() == null)
            throw new GlobalException("Email is mandatory");
        if(userDetails.getFirstName() == null)
            throw new GlobalException("Firstname is mandatory");
        if(userDetails.getLastName() == null)
            throw new GlobalException("Lastname is mandatory");
    }

    @Override
    public UserDetails updateUserDetails(Integer userId, UserDetails userDetails) {
        UserDetails userObj = userRepository.getUserDetailsById(userId);

        if(!userObj.getUserId().equals(userDetails.getUserId()))
            throw new UserNotFoundException("User id can't be change");
        if(!userObj.getUserName().equals(userDetails.getUserName()))
            throw new GlobalException("Username can't be change");
        if(!userObj.getMobileNumber().equals(userDetails.getMobileNumber()))
            throw new GlobalException("Mobile number can't be change");
        if(!userObj.getEmail().equals(userDetails.getEmail()))
            throw new GlobalException("Email can't be change");

        updateUserDetailsObject(userDetails, userObj);
        return userRepository.updateUserDetails(userDetails);
    }

    private void updateUserDetailsObject(UserDetails newUser, UserDetails oldUser) {
        BeanUtils.copyProperties(oldUser, newUser);
    }

}
