package com.anton.TutoringNetwork.service;

import com.anton.TutoringNetwork.entity.StudentEntity;
import com.anton.TutoringNetwork.model.Student;
import com.anton.TutoringNetwork.repository.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


@Service
public class StudentServiceImp implements StudentService {
    StudentRepository studentRepository;

    public StudentServiceImp(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student createStudent(Student student) {
        StudentEntity entity = new StudentEntity();
        BeanUtils.copyProperties(student,entity);
        studentRepository.save(entity);
        return student;
    }
}
