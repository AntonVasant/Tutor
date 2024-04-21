package com.anton.TutoringNetwork.controller;

import com.anton.TutoringNetwork.dto.AuthenticationResponse;
import com.anton.TutoringNetwork.model.auth.LoginRequest;
import com.anton.TutoringNetwork.model.auth.RegistrationRequest;
import com.anton.TutoringNetwork.service.AuthStudentsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/v1")
public class AuthStudentController {
    public AuthStudentController(AuthStudentsService authService) {
        this.authService = authService;
    }

    AuthStudentsService authService;
    @PostMapping("student/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest){
        AuthenticationResponse authenticationResponse = authService.authenticateUser(loginRequest);
        return ResponseEntity.ok(authenticationResponse);
    }
    @PostMapping("student/register")
    public ResponseEntity<?> registerUser(@RequestBody RegistrationRequest registrationRequest){
        authService.registerUser(registrationRequest);
        return ResponseEntity.ok("User registered successfully");
    }
}
