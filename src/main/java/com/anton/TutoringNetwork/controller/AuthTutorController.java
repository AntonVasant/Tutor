package com.anton.TutoringNetwork.controller;

import com.anton.TutoringNetwork.dto.AuthenticationResponse;
import com.anton.TutoringNetwork.model.auth.LoginRequest;
import com.anton.TutoringNetwork.model.auth.RegistrationRequest;
import com.anton.TutoringNetwork.service.AuthStudentsService;
import com.anton.TutoringNetwork.service.AuthTutorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AuthTutorController {

    public AuthTutorController(AuthTutorService authService) {
        this.authService = authService;
    }

    AuthTutorService authService;
    @PostMapping("tutor/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest){
        AuthenticationResponse authenticationResponse = authService.authenticateUser(loginRequest);
        return ResponseEntity.ok(authenticationResponse);
    }
    @PostMapping("tutor/register")
    public ResponseEntity<?> registerUser(@RequestBody RegistrationRequest registrationRequest){
        authService.registerUser(registrationRequest);
        return ResponseEntity.ok("User registered successfully");
    }
}
