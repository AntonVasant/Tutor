package com.anton.TutoringNetwork.service;

import com.anton.TutoringNetwork.entity.TutorEntity;
import com.anton.TutoringNetwork.model.Tutor;
import com.anton.TutoringNetwork.repository.TutorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutorServiceImp implements TutorService{

    public TutorServiceImp(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }

    TutorRepository tutorRepository;
    @Override
    public Tutor createTutor(Tutor tutor) {
        TutorEntity entity = new TutorEntity();
        BeanUtils.copyProperties(tutor,entity);
        tutorRepository.save(entity);
        return tutor;
    }

    @Override
    public List<TutorEntity> getAllTutors() {
       return tutorRepository.findAll();
    }

    @Override
    public Optional<TutorEntity> getTutor(Long id) {
         return tutorRepository.findById(id);
    }


}
