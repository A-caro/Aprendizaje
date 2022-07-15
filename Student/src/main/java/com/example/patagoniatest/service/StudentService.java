package com.example.patagoniatest.service;

import com.example.patagoniatest.entity.Student;
import com.example.patagoniatest.feignclients.SubjectFeignClient;
import com.example.patagoniatest.model.Subject;
import com.example.patagoniatest.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;


@Service
@Transactional
@Slf4j
public class StudentService {


    @Autowired
    SubjectFeignClient subjectFeignClient;

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getClients() {
        return studentRepository.findAll();
    }
    

    public Subject saveSubject(Long Id, Subject subject){
        subject.setId(Id);
        Subject subject1 = subjectFeignClient.saveSubject(subject);
        return subject1;
    }

  


}

