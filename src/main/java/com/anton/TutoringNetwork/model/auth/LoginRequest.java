package com.anton.TutoringNetwork.model.auth;

import lombok.Data;

@Data
public class LoginRequest {
    private String userName;
    private String password;
}
