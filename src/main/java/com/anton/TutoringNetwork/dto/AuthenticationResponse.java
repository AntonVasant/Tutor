package com.anton.TutoringNetwork.dto;

import lombok.Data;

@Data
public class AuthenticationResponse {
    private String token;
    private String userName;
    private String email;
}
