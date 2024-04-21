package com.anton.TutoringNetwork.service;

import com.anton.TutoringNetwork.dto.AuthenticationResponse;
import com.anton.TutoringNetwork.model.Student;
import com.anton.TutoringNetwork.model.auth.LoginRequest;
import com.anton.TutoringNetwork.model.auth.RegistrationRequest;
import com.anton.TutoringNetwork.repository.AuthStudentRepository;
import com.anton.TutoringNetwork.repository.AuthTutorRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthStudentsService {

    private AuthStudentRepository authStudentRepository;
    private PasswordEncoder passwordEncoder;

    public AuthStudentsService(AuthStudentRepository authStudentRepository) {
        this.authStudentRepository = authStudentRepository;
    }

    public AuthStudentsService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public AuthenticationResponse authenticateUser(LoginRequest loginRequest) {
        Student student = authStudentRepository.findByUserName(loginRequest.getUserName());
        if(student != null && passwordEncoder.matches(loginRequest.getPassword(),student.getPassword())){

            AuthenticationResponse authenticationResponse = new AuthenticationResponse();
            authenticationResponse.setEmail(student.getEmail());
            authenticationResponse.setUserName(student.getUserName());
            return authenticationResponse;
        }else {
            return null;
        }
    }

    public void registerUser(RegistrationRequest registrationRequest) {
        if(authStudentRepository.existsByUserName(registrationRequest.getUserName())){
            throw new IllegalArgumentException("username already exists");
        }
        if(authStudentRepository.existsByEmail(registrationRequest.getEmail())){
            throw new IllegalArgumentException("email already taken");
        }
        Student student = new Student();
        student.setEmail(registrationRequest.getEmail());
        student.setUserName(registrationRequest.getUserName());
        student.setPassword(registrationRequest.getPassword());
    }
}
