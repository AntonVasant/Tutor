package com.anton.TutoringNetwork.controller;

import com.anton.TutoringNetwork.model.Student;
import com.anton.TutoringNetwork.service.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    StudentService studentService;
    @PostMapping("create/user")
    public Student createStudent(@RequestBody  Student student)
    {
        return studentService.createStudent(student);
    }
}
