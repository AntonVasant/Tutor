package com.anton.TutoringNetwork.repository;

import com.anton.TutoringNetwork.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity,Long> {
}
