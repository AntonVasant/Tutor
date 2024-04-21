package com.anton.TutoringNetwork.service;

import com.anton.TutoringNetwork.dto.AuthenticationResponse;
import com.anton.TutoringNetwork.model.Tutor;
import com.anton.TutoringNetwork.model.auth.LoginRequest;
import com.anton.TutoringNetwork.model.auth.RegistrationRequest;
import com.anton.TutoringNetwork.repository.AuthTutorRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthTutorService {

    public AuthTutorService(AuthTutorRepository authTutorRepository) {
        this.authTutorRepository = authTutorRepository;
    }

    private AuthTutorRepository authTutorRepository;

    public AuthTutorService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    private PasswordEncoder passwordEncoder;

    public AuthenticationResponse authenticateUser(LoginRequest loginRequest) {
        Tutor tutor = authTutorRepository.findByUserName(loginRequest.getUserName());
        if(tutor != null && passwordEncoder.matches(loginRequest.getPassword(),tutor.getPassword())){
            AuthenticationResponse authenticationResponse = new AuthenticationResponse();

            authenticationResponse.setUserName(tutor.getUserName());
            authenticationResponse.setEmail(tutor.getEmail());
            return authenticationResponse;
        }
        return null;

    }

    public void registerUser(RegistrationRequest registrationRequest) {
        if(authTutorRepository.existsByUserName(registrationRequest.getUserName())){
            throw new IllegalArgumentException("username already exists");
        }
        if(authTutorRepository.existsByEmail(registrationRequest.getEmail())){
            throw new IllegalArgumentException("email already taken");
        }
        Tutor tutor = new Tutor();
        tutor.setUserName(registrationRequest.getUserName());
        tutor.setEmail(registrationRequest.getEmail());
        tutor.setPassword(registrationRequest.getPassword());
    }
}
