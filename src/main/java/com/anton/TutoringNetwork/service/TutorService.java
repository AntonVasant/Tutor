package com.anton.TutoringNetwork.service;

import com.anton.TutoringNetwork.entity.TutorEntity;
import com.anton.TutoringNetwork.model.Tutor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface TutorService {
    Tutor createTutor(Tutor tutor);

    List<TutorEntity> getAllTutors();

    Optional<TutorEntity> getTutor(Long id);
}
