package com.example.patagoniatest.controller;

import com.example.patagoniatest.entity.Student;
import com.example.patagoniatest.model.Subject;
import com.example.patagoniatest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getClients(){
        return studentService.getClients();
    }



    @PostMapping("/saveSubject/{Id}")
    public ResponseEntity<Subject> saveSubject(@PathVariable("Id") Long Id, @RequestBody Subject subject) {
        Subject subject1 = studentService.saveSubject(Id, subject);
        return ResponseEntity.ok(subject);
    }

}
