package com.notification.service.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDetails {

    private Integer userId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String userName;
    private String password;
    private String email;
    private String mobileNumber;
    private Character activeStatus;

}
