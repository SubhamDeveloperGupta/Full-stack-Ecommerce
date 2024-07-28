package com.user.management.user_management_service.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;
    private String firstName;
    private String middleName;
    private String lastName;
    @Column(unique = true)
    private String userName;
    private String password;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String mobileNumber;
    @Column(name = "active_status", nullable = false, length = 1)
    private Character activeStatus;

}
