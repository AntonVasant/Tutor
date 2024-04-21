package com.anton.TutoringNetwork.model.auth;

import lombok.Data;

import java.time.LocalDate;
@Data
public class RegistrationRequest {

    private String userName;
    private String password;
    private String confirmPassword;
    private  String email;
    private LocalDate dob;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
}
