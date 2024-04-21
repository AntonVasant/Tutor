package com.anton.TutoringNetwork.model;

import lombok.Data;

@Data
public class Student {
    private Long id;
    private String userName;
    private String email;
    private String password;
}
