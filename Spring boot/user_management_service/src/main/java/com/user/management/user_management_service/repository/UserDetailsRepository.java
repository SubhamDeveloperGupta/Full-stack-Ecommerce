package com.user.management.user_management_service.repository;

import com.user.management.user_management_service.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer> {

    boolean existsByUserName(String username);
    boolean existsByEmail(String email);
    boolean existsByMobileNumber(String mobileNumber);

}
