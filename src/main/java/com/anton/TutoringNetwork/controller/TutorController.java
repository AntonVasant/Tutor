package com.anton.TutoringNetwork.controller;

import com.anton.TutoringNetwork.entity.TutorEntity;
import com.anton.TutoringNetwork.model.Tutor;
import com.anton.TutoringNetwork.service.TutorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class TutorController {

    public TutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    TutorService tutorService;
    @PostMapping("put/tutor")
    public Tutor createTutor(@RequestBody Tutor tutor)
    {
        return tutorService.createTutor(tutor);
    }

    @GetMapping("tutors")
    public List<TutorEntity> getTutors()
    {
       return tutorService.getAllTutors();
    }

    @GetMapping("tutor/{id}")
    public Optional<TutorEntity> getTutor(@PathVariable Long id)
    {
        return tutorService.getTutor(id);
    }
}
