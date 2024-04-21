package com.anton.TutoringNetwork.repository;

import com.anton.TutoringNetwork.entity.TutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorRepository extends JpaRepository<TutorEntity,Long> {
}
