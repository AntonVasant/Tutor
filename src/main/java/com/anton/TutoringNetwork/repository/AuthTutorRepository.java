package com.anton.TutoringNetwork.repository;

import com.anton.TutoringNetwork.entity.TutorEntity;
import com.anton.TutoringNetwork.model.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthTutorRepository extends JpaRepository<TutorEntity,Long> {
    Tutor findByUserName(String userName);

    boolean existsByUserName(String userName);

    boolean existsByEmail(String email);
}
