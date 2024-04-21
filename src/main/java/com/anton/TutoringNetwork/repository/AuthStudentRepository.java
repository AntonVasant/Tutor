package com.anton.TutoringNetwork.repository;

import com.anton.TutoringNetwork.entity.StudentEntity;
import com.anton.TutoringNetwork.model.Student;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthStudentRepository extends JpaRepository<StudentEntity,Long> {
    Student findByUserName(String username);
    boolean existsByUserName(String username);
    boolean existsByEmail(String email);
}
